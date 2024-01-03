package com.example.mediumspringwebflux.board.dto;

import lombok.Builder;

@Builder
public record BoardResponse(
        String id,
        String title,
        String description
) {
}
