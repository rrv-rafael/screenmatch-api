package com.rrv.screenmatch.mapper;

import com.rrv.screenmatch.dto.EpisodeResponse;
import com.rrv.screenmatch.dto.OmdbEpisodeResponse;
import com.rrv.screenmatch.entity.Episode;
import com.rrv.screenmatch.entity.Series;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EpisodeMapper {
    public Episode toEntity(OmdbEpisodeResponse episodeResponse, Series series, Integer seasonNumber) {
        return Episode.builder()
                .season(seasonNumber)
                .title(episodeResponse.title())
                .number(Integer.valueOf(episodeResponse.episode()))
                .rating(parseRating(episodeResponse.imdbRating()))
                .releaseDate(parseReleaseDate(episodeResponse.released()))
                .series(series)
                .build();
    }

    private Double parseRating(String rating) {
        if (rating == null || rating.equalsIgnoreCase("N/A")) {
            return null;
        }

        return Double.valueOf(rating);
    }

    private LocalDate parseReleaseDate(String releseDate) {
        if (releseDate == null || releseDate.equalsIgnoreCase("N/A")) {
            return null;
        }

        return LocalDate.parse(releseDate);
    }

    public EpisodeResponse toResponse(Episode episode) {
        return EpisodeResponse.builder()
                .id(episode.getId())
                .season(episode.getSeason())
                .title(episode.getTitle())
                .releaseDate(episode.getReleaseDate())
                .number(episode.getNumber())
                .rating(episode.getRating())
                .build();
    }

    public List<EpisodeResponse> toReponse(List<Episode> episodes) {
        return episodes.stream()
                .map(this::toResponse)
                .toList();
    }
}
