package com.example.studygraphql.model;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    protected Board() {}

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and setters
}