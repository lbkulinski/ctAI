package net.lbku.service;

import net.lbku.client.api.StationApi;
import net.lbku.client.invoker.ApiException;
import net.lbku.client.model.Train;
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
    private final StationApi stationApi;

    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(TrainService.class);
    }

    @Autowired
    public TrainService(StationApi stationApi) {
        this.stationApi = Objects.requireNonNull(stationApi);
    }

    @Override
    public Response apply(Request request) {
        int stationId = request.stationId();

        List<Train> trains;

        try {
            trains = this.stationApi.getArrivals(stationId);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }

        return new Response(trains);
    }
}
