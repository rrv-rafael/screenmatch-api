package com.rrv.screenmatch.dto;

import com.rrv.screenmatch.enums.Genre;
import lombok.Builder;

@Builder
public record SeriesResponse(
        Long id,
        String title,
        Genre genre,
        String cast,
        String plot,
        String poster,
        Double rating,
        Integer totalSeasons
) {
}
