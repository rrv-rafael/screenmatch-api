package com.rrv.screenmatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbEpisodeResponse(
        @JsonProperty("Title") String title,
        @JsonProperty("Released") String released,
        @JsonProperty("Episode") String episode,
        @JsonProperty("imdbRating") String imdbRating
) {
}
