package com.rrv.screenmatch.repository;

import com.rrv.screenmatch.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
