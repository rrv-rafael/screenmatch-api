package com.rrv.screenmatch.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Genre {
    ACTION("Action", "ação"),
    ADVENTURE("Adventure", "aventura"),
    ANIMATION("Animation", "animação"),
    COMEDY("Comedy", "comédia"),
    CRIME("Crime", "crime"),
    DRAMA("Drama", "drama"),
    ROMANCE("Romance", "romance"),
    HORROR("Horror", "terror");

    private final String omdbValue;
    private final String frontendValue;

    public static Genre fromOmdb(String genre) {
        if (genre == null || genre.isBlank() || genre.equalsIgnoreCase("N/A")) {
            return null;
        }

        String firstGenre = genre.split(",")[0].trim();

        return Arrays.stream(values())
                .filter(g -> g.getOmdbValue().equalsIgnoreCase(firstGenre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhum gênero encontrado para: " + firstGenre));
    }

    public static Genre fromFrontend(String genre) {
        return Arrays.stream(values())
                .filter(g -> g.getFrontendValue().equalsIgnoreCase(genre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Gênero não encontrado!"));
    }
}
