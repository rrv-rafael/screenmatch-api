package com.rrv.screenmatch.mapper;

import com.rrv.screenmatch.dto.OmdbSeriesResponse;
import com.rrv.screenmatch.dto.SeriesResponse;
import com.rrv.screenmatch.entity.Series;
import com.rrv.screenmatch.enums.Genre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeriesMapper {
    public Series toEntity(OmdbSeriesResponse omdbSeriesResponse) {
        return Series.builder()
                .title(omdbSeriesResponse.title())
                .genre(Genre.fromOmdb(omdbSeriesResponse.genre()))
                .actors(omdbSeriesResponse.actors())
                .plot(omdbSeriesResponse.plot())
                .poster(omdbSeriesResponse.poster())
                .rating(omdbSeriesResponse.imdbRating())
                .totalSeasons(omdbSeriesResponse.totalSeasons())
                .build();
    }

    public SeriesResponse toResponse(Series series) {
        return SeriesResponse.builder()
                .id(series.getId())
                .title(series.getTitle())
                .genre(series.getGenre())
                .cast(series.getActors())
                .plot(series.getPlot())
                .poster(series.getPoster())
                .rating(series.getRating())
                .totalSeasons(series.getTotalSeasons())
                .build();
    }

    public List<SeriesResponse> toResponse(List<Series> series) {
        return series.stream()
                .map(this::toResponse)
                .toList();
    }
}
