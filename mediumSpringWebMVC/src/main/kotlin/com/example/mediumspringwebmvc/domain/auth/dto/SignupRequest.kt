package com.example.mediumspringwebmvc.domain.auth.dto

data class SignupRequest(
    val name: String,
    val email: String,
    val password: String,
)
