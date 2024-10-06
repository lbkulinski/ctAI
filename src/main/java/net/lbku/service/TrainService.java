package net.lbku.service;

import net.lbku.model.Train;
import net.lbku.model.TrainResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
@Description("Retrieves train arrivals for the specified station ID")
public final class TrainService implements Function<Request, Response> {
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

    @Override
    public Response apply(Request request) {
        RestClient client = RestClient.builder()
                                      .baseUrl(this.cta4jUrl)
                                      .build();

        int stationId = request.stationId();

        String payload = this.getPayload(stationId);

        TrainResponse response = client.post()
                                       .uri("/graphql")
                                       .body(payload)
                                       .contentType(MediaType.APPLICATION_JSON)
                                       .retrieve()
                                       .body(TrainResponse.class);

        if (response == null) {
            TrainService.LOGGER.error("Failed to retrieve trains from cta4j API");

            List<Train> trains = List.of();

            return new Response(trains);
        }

        List<Train> trains = response.body()
                                     .trains();

        trains = List.copyOf(trains);

        return new Response(trains);
    }
}
