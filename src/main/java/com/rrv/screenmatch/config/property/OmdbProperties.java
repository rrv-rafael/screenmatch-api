package com.rrv.screenmatch.config.property;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "omdb")
public record OmdbProperties(
        @NotBlank @URL String baseUrl,
        @NotBlank String apiKey
) {
}
