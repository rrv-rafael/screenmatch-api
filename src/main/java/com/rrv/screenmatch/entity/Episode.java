package com.rrv.screenmatch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "episode")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer season;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;
}
