package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    @Query("""
            SELECT e
            FROM Episode e
            WHERE e.series.id = :id
            ORDER BY e.season
            """)
    List<Episode> findEpisodesBySeriesId(@Param("id") Long id);
}
