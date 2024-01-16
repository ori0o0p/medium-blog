package com.example.mediumspringwebflux.domain.auth.service;

import com.example.mediumspringwebflux.domain.auth.dto.LoginRequest;
import com.example.mediumspringwebflux.domain.user.repository.UserRepository;
import com.example.mediumspringwebflux.global.security.Tokenizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class Login {
    private final UserRepository userRepository;
    private final Tokenizer tokenizer;
    private final PasswordEncoder passwordEncoder;

    public Login(UserRepository userRepository, Tokenizer tokenizer, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenizer = tokenizer;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<Void> execute(LoginRequest request) {
        return Mono.empty();
    }

}
