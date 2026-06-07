package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findBySeriesIdOrderBySeason(Long id);

    List<Episode> findBySeriesIdAndSeasonOrderByNumberAsc(Long id, Integer season);
}
