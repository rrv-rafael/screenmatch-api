package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Series;
import com.rrv.screenmatch.enums.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findTop5ByOrderByRatingDesc();

    Optional<Series> findByTitleIgnoreCase(String titile);

    @Query("""
            SELECT s
            FROM Series s
            JOIN s.episodes e
            GROUP BY s
            ORDER BY MAX(e.releaseDate) DESC
            """)
    List<Series> findWithLatestEpisodes(Pageable pageable);

    List<Series> findByGenre(Genre genre);
}
