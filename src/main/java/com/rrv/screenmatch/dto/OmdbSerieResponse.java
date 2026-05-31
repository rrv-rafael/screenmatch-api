package com.rrv.screenmatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbSerieResponse(
        @JsonProperty("Title") String title,
        @JsonProperty("Genre") String genre,
        @JsonProperty("Actors") String actors,
        @JsonProperty("Plot") String plot,
        @JsonProperty("Poster") String poster,
        @JsonProperty("imdbRating") Double imdbRating,
        @JsonProperty("totalSeasons") Integer totalSeasons
) {
}
