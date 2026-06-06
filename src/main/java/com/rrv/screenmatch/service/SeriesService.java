package com.rrv.screenmatch.service;

import com.rrv.screenmatch.client.OmdbApiClient;
import com.rrv.screenmatch.dto.EpisodeResponse;
import com.rrv.screenmatch.dto.OmdbSeasonResponse;
import com.rrv.screenmatch.dto.SeriesResponse;
import com.rrv.screenmatch.entity.Episode;
import com.rrv.screenmatch.entity.Series;
import com.rrv.screenmatch.mapper.EpisodeMapper;
import com.rrv.screenmatch.mapper.SeriesMapper;
import com.rrv.screenmatch.repository.EpisodeRepository;
import com.rrv.screenmatch.repository.SeriesRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesMapper seriesMapper;
    private final EpisodeMapper episodeMapper;
    private final OmdbApiClient omdbApiClient;
    private final SeriesRepository seriesRepository;
    private final EpisodeRepository episodeRepository;

    public SeriesResponse create(String title) {
        Series series = seriesMapper.toEntity(omdbApiClient.findSeriesByTitle(title));

        return seriesMapper.toResponse(seriesRepository.save(series));
    }

    public List<EpisodeResponse> createEpisodes(String seriesTitle) {
        Series series = findByTitle(seriesTitle);

        List<Episode> episodes = fetchEpisodesFromOmdb(series);

        return episodeMapper.toReponse(episodeRepository.saveAll(episodes));
    }

    public Series findByTitle(String title) {
        return seriesRepository.findByTitleIgnoreCase(title)
                .orElseThrow(() -> new EntityNotFoundException("Série não encontrada!"));
    }

    public List<Episode> fetchEpisodesFromOmdb(Series series) {
        List<Episode> episodes = new ArrayList<>();

        for (int seasonNumber = 1; seasonNumber <= series.getTotalSeasons(); seasonNumber++) {
            OmdbSeasonResponse seasonResponse = omdbApiClient.findSeasonByTitle(series.getTitle(), seasonNumber);

            episodes.addAll(
                    seasonResponse.episodes().stream()
                            .map(e -> episodeMapper.toEntity(e, series, seasonResponse.season()))
                            .toList()
            );
        }

        return episodes;
    }

    public List<SeriesResponse> findAll() {
        return seriesMapper.toResponse(seriesRepository.findAll());
    }

    public List<SeriesResponse> findTop5() {
        return seriesMapper.toResponse(seriesRepository.findTop5ByOrderByRatingDesc());
    }
}
