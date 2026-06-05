package com.rrv.screenmatch.dto;

import jakarta.validation.constraints.NotBlank;

public record SeriesRequest(
        @NotBlank String title
) {
}
