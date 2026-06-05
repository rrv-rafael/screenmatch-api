package com.rrv.screenmatch.service;

import com.rrv.screenmatch.client.OmdbClient;
import com.rrv.screenmatch.dto.SeriesResponse;
import com.rrv.screenmatch.entity.Series;
import com.rrv.screenmatch.mapper.SeriesMapper;
import com.rrv.screenmatch.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesMapper seriesMapper;
    private final OmdbClient omdbClient;
    private final SeriesRepository seriesRepository;

    public SeriesResponse create(String title) {
        Series series = seriesMapper.toEntity(omdbClient.findByTitle(title));

        return seriesMapper.toResponse(seriesRepository.save(series));
    }

    public List<SeriesResponse> findAll() {
        return seriesMapper.toResponse(seriesRepository.findAll());
    }

    public List<SeriesResponse> findTop5() {
        return seriesMapper.toResponse(seriesRepository.findTop5ByOrderByRatingDesc());
    }
}
