package com.example.mediumspringwebflux.board.dto;

public record BoardRequest(
        String title,
        String description
) {
}
