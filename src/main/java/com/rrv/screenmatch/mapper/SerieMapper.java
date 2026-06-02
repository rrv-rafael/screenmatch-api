package com.rrv.screenmatch.mapper;

import com.rrv.screenmatch.dto.OmdbSerieResponse;
import com.rrv.screenmatch.dto.SerieResponse;
import com.rrv.screenmatch.entity.Serie;
import com.rrv.screenmatch.enums.Genre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SerieMapper {
    public Serie toEntity(OmdbSerieResponse omdbSerieResponse) {
        return Serie.builder()
                .title(omdbSerieResponse.title())
                .genre(Genre.fromOmdb(omdbSerieResponse.genre()))
                .actors(omdbSerieResponse.actors())
                .plot(omdbSerieResponse.plot())
                .poster(omdbSerieResponse.poster())
                .rating(omdbSerieResponse.imdbRating())
                .totalSeasons(omdbSerieResponse.totalSeasons())
                .build();
    }

    public SerieResponse toResponse(Serie serie) {
        return SerieResponse.builder()
                .id(serie.getId())
                .title(serie.getTitle())
                .genre(serie.getGenre())
                .cast(serie.getActors())
                .plot(serie.getPlot())
                .poster(serie.getPoster())
                .rating(serie.getRating())
                .totalSeasons(serie.getTotalSeasons())
                .build();
    }

    public List<SerieResponse> toResponse(List<Serie> series) {
        return series.stream()
                .map(this::toResponse)
                .toList();
    }
}
