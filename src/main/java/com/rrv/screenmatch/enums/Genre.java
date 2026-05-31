package com.rrv.screenmatch.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Genre {
    ACTION("Action"),
    ANIMATION("Animation"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    HORROR("Horror");

    private final String omdbValue;

    public static Genre fromOmdb(String genre) {
        if (genre == null || genre.isBlank() || genre.equalsIgnoreCase("N/A")) {
            return null;
        }

        String firstGenre = genre.split(",")[0].trim();

        return Arrays.stream(values())
                .filter(g -> g.omdbValue.equalsIgnoreCase(firstGenre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhum gênero encontrado para: " + firstGenre));
    }
}
