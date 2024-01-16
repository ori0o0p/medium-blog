package com.example.mediumspringwebflux.domain.auth.dto;

import lombok.Builder;

@Builder
public record LoginResponse(
        String token
) {
}
