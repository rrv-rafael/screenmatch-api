package com.rrv.screenmatch.controller;

import com.rrv.screenmatch.dto.SeriesRequest;
import com.rrv.screenmatch.dto.SeriesResponse;
import com.rrv.screenmatch.service.SeriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
