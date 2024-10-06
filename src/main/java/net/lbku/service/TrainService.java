package net.lbku.service;

import net.lbku.model.Train;
import net.lbku.model.TrainResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
public final class TrainService {
    private final String cta4jUrl;

    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(TrainService.class);
    }

    @Autowired
    public TrainService(@Value("${cta4j.api-url}") String cta4jUrl) {
        this.cta4jUrl = Objects.requireNonNull(cta4jUrl);
    }

    private String getPayload(int stationId) {
        String query = """
        query Trains($stationId: ID!) { \
          trains(stationId: $stationId) { \
            line \
            destination \
            run \
            predictionTime \
            arrivalTime \
            due \
            scheduled \
            delayed \
            __typename \
          } \
        }""";

        return """
        {
          "operationName": "Trains",
          "variables": {
            "stationId": "%d"
          },
          "query": "%s"
        }""".formatted(stationId, query);
    }

    public List<Train> getTrains(int stationId) {
        RestClient client = RestClient.builder()
                                      .baseUrl(this.cta4jUrl)
                                      .build();

        String payload = this.getPayload(stationId);

        TrainResponse response = client.post()
                                       .uri("/graphql")
                                       .body(payload)
                                       .contentType(MediaType.APPLICATION_JSON)
                                       .retrieve()
                                       .body(TrainResponse.class);

        if (response == null) {
            TrainService.LOGGER.error("Failed to retrieve trains from cta4j API");

            return List.of();
        }

        List<Train> trains = response.body()
                                     .trains();

        return List.copyOf(trains);
    }
}
