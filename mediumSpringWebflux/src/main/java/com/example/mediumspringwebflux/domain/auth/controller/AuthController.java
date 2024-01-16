package com.example.mediumspringwebflux.domain.auth.controller;

import com.example.mediumspringwebflux.domain.auth.dto.LoginRequest;
import com.example.mediumspringwebflux.domain.auth.dto.LoginResponse;
import com.example.mediumspringwebflux.domain.auth.service.Login;
import com.example.mediumspringwebflux.domain.auth.service.Signup;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final Login login;
    private final Signup signup;

    public AuthController(Login login, Signup signup) {
        this.login = login;
        this.signup = signup;
    }

    @PostMapping("/login")
    public Mono<LoginResponse> setLogin(@RequestBody LoginRequest request) {
        return login.execute(request);
    }

}
