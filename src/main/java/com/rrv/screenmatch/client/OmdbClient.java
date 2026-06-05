package com.rrv.screenmatch.client;

import com.rrv.screenmatch.config.property.OmdbProperties;
import com.rrv.screenmatch.dto.OmdbSeriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class OmdbClient {
    private final RestClient omdbRestClient;
    private final OmdbProperties omdbProperties;

    public OmdbSeriesResponse findByTitle(String title) {
        return omdbRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("t", title)
                        .queryParam("apikey", omdbProperties.apiKey())
                        .build())
                .retrieve()
                .body(OmdbSeriesResponse.class);
    }
}
