package com.rrv.screenmatch.dto;

import jakarta.validation.constraints.NotBlank;

public record SerieRequest(
        @NotBlank String title
) {
}
