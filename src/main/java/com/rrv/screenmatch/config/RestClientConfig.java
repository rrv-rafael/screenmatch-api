package com.rrv.screenmatch.config;

import com.rrv.screenmatch.config.property.OmdbProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties({OmdbProperties.class})
public class RestClientConfig {
    @Bean
    public RestClient omdbRestClient(OmdbProperties omdbProperties) {
        return RestClient.builder()
                .baseUrl(omdbProperties.baseUrl())
                .build();
    }
}
