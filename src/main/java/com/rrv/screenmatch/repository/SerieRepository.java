package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findTop5ByOrderByRatingDesc();
}
