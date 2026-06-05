package com.rrv.screenmatch.controller;

import com.rrv.screenmatch.dto.SerieRequest;
import com.rrv.screenmatch.dto.SerieResponse;
import com.rrv.screenmatch.service.SerieService;
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
public class SerieController {
    private final SerieService serieService;

    @GetMapping
    public ResponseEntity<List<SerieResponse>> getSeries() {
        return ResponseEntity.ok(serieService.findAll());
    }

    @GetMapping("/top5")
    public ResponseEntity<List<SerieResponse>> getTop5() {
        return ResponseEntity.ok(serieService.findTop5());
    }

    @PostMapping
    public ResponseEntity<SerieResponse> create(@RequestBody @Valid SerieRequest serieRequest) {
        SerieResponse serieResponse = serieService.create(serieRequest.title());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(serieResponse.id())
                .toUri();

        return ResponseEntity.created(location).body(serieResponse);
    }
}
