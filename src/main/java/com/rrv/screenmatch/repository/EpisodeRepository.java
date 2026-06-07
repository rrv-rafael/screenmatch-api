package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Episode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findBySeriesIdOrderBySeason(Long id);

    List<Episode> findBySeriesIdAndSeasonOrderByNumberAsc(Long id, Integer season);

    @Query("""
            SELECT e
            FROM Episode e
            WHERE e.series.id = :id
                  AND e.rating IS NOT NULL
            ORDER BY e.rating DESC
            """)
    List<Episode> findTopRatedBySeriesId(@Param("id") Long id, Pageable pageable);
}
