package com.rrv.screenmatch.dto;

import jakarta.validation.constraints.NotEmpty;

public record EpisodeRequest(
        @NotEmpty String seriesTitle
) {
}
