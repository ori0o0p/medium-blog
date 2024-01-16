package com.example.mediumspringwebflux.domain.auth.dto;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
