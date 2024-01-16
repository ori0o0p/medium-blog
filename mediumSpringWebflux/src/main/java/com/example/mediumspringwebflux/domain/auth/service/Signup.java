package com.example.mediumspringwebflux.domain.auth.service;

import com.example.mediumspringwebflux.domain.user.repository.UserRepository;
import com.example.mediumspringwebflux.global.security.Tokenizer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class Signup {
    private final UserRepository userRepository;
    private final Tokenizer tokenizer;

    public Signup(UserRepository userRepository, Tokenizer tokenizer) {
        this.userRepository = userRepository;
        this.tokenizer = tokenizer;
    }

    public Mono<Void> execute() {
        return Mono.empty();
    }

}
