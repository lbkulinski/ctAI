package net.lbku.config;

import net.lbku.client.api.StationApi;
import net.lbku.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ApiClientConfiguration {
    private final ApiClient apiClient;

    @Autowired
    public ApiClientConfiguration(@Value("${cta4j.api-url}") String apiUrl) {
        Objects.requireNonNull(apiUrl);

        this.apiClient = new ApiClient();

        this.apiClient.setBasePath(apiUrl);
    }

    @Bean
    public StationApi stationApi() {
        return new StationApi(apiClient);
    }
}
