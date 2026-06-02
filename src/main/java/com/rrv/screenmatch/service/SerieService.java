package com.rrv.screenmatch.service;

import com.rrv.screenmatch.client.OmdbClient;
import com.rrv.screenmatch.dto.SerieResponse;
import com.rrv.screenmatch.entity.Serie;
import com.rrv.screenmatch.mapper.SerieMapper;
import com.rrv.screenmatch.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {
    private final SerieMapper serieMapper;
    private final OmdbClient omdbClient;
    private final SerieRepository serieRepository;

    public SerieResponse create(String title) {
        Serie serie = serieMapper.toEntity(omdbClient.findByTitle(title));

        return serieMapper.toResponse(serieRepository.save(serie));
    }

    public List<SerieResponse> findAll() {
        return serieMapper.toResponse(serieRepository.findAll());
    }
}
