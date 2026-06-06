package com.rrv.screenmatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbSeasonResponse(
        @JsonProperty("Title") String title,
        @JsonProperty("Season") Integer season,
        @JsonProperty("Episodes") List<OmdbEpisodeResponse> episodes
) {
}
