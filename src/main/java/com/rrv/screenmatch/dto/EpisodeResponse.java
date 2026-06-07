package com.rrv.screenmatch.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EpisodeResponse(
        Long id,
        Integer season,
        String title,
        LocalDate releaseDate,
        Integer number,
        Double rating
) {
}
