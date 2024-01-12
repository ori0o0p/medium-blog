package com.example.mediumspringwebflux.domain.board.dto;

import lombok.NonNull;

public record BoardRequest(
        @NonNull
        String title,
        String description
) {
}
