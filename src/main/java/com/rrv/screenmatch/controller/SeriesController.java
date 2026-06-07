package com.rrv.screenmatch.controller;

import com.rrv.screenmatch.dto.EpisodeRequest;
import com.rrv.screenmatch.dto.EpisodeResponse;
import com.rrv.screenmatch.dto.SeriesRequest;
import com.rrv.screenmatch.dto.SeriesResponse;
import com.rrv.screenmatch.service.SeriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;

    @GetMapping
    public ResponseEntity<List<SeriesResponse>> getAll() {
        return ResponseEntity.ok(seriesService.findAll());
    }

    @GetMapping("/top5")
    public ResponseEntity<List<SeriesResponse>> getTop5() {
        return ResponseEntity.ok(seriesService.findTop5());
    }

    @GetMapping("/latest-releases")
    public ResponseEntity<List<SeriesResponse>> getLatestReleases() {
        return ResponseEntity.ok(seriesService.findLatestReleases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(seriesService.findById(id));
    }

    @GetMapping("/{id}/episodes")
    public ResponseEntity<List<EpisodeResponse>> getEpisodesBySeriesId(@PathVariable Long id) {
        return ResponseEntity.ok(seriesService.findEpisodesBySeriesId(id));
    }

    @GetMapping("/{id}/seasons/{season}/episodes")
    public ResponseEntity<List<EpisodeResponse>> getEpisodesBySeriesIdAndSeason(@PathVariable Long id, @PathVariable Integer season) {
        return ResponseEntity.ok(seriesService.findEpisodesBySeriesIdAndSeason(id, season));
    }

    @PostMapping("/episodes")
    public ResponseEntity<List<EpisodeResponse>> getSeries(@RequestBody @Valid EpisodeRequest episodeRequest) {
        List<EpisodeResponse> episodesResponse = seriesService.createEpisodes(episodeRequest.seriesTitle());

        return ResponseEntity.status(HttpStatus.CREATED).body(episodesResponse);
    }

    @PostMapping
    public ResponseEntity<SeriesResponse> create(@RequestBody @Valid SeriesRequest seriesRequest) {
        SeriesResponse seriesResponse = seriesService.create(seriesRequest.title());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(seriesResponse.id())
                .toUri();

        return ResponseEntity.created(location).body(seriesResponse);
    }
}
