package com.example.mediumspringwebflux.domain.auth.service;

import com.example.mediumspringwebflux.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class Login {
    private final UserRepository userRepository;

    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Void> execute() {
        return Mono.empty();
    }

}
