package com.example.mediumspringwebmvc.domain.auth.service

import com.example.mediumspringwebmvc.domain.auth.dto.LoginRequest
import com.example.mediumspringwebmvc.domain.auth.dto.SignupRequest
import com.example.mediumspringwebmvc.domain.auth.dto.TokenResponse
import org.springframework.stereotype.Component

@Component
abstract class AuthComponent {
    abstract fun login(request: LoginRequest): TokenResponse
    abstract fun signup(request: SignupRequest)

}