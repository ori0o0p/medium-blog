package com.example.mediumspringwebflux.domain.auth.controller;

import com.example.mediumspringwebflux.domain.auth.service.Login;
import com.example.mediumspringwebflux.domain.auth.service.Signup;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final Login login;
    private final Signup signup;

    public AuthController(Login login, Signup signup) {
        this.login = login;
        this.signup = signup;
    }

}
