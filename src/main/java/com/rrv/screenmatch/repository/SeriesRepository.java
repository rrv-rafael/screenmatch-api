package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findTop5ByOrderByRatingDesc();

    Optional<Series> findByTitleIgnoreCase(String titile);
}
