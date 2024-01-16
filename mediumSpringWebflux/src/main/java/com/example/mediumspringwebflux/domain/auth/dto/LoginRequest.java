package com.example.mediumspringwebflux.domain.auth.dto;

public record LoginRequest(
        String email,
        String password
) {
}
