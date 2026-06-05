package com.rrv.screenmatch.entity;

import com.rrv.screenmatch.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private String actors;

    @Column(nullable = false)
    private String plot;

    @Column(nullable = false)
    private String poster;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer totalSeasons;

    @OneToMany(mappedBy = "series", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Episode> episodes = new ArrayList<>();
}
