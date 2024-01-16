package com.example.mediumspringwebflux.domain.auth.service;

import com.example.mediumspringwebflux.domain.auth.dto.SignupRequest;
import com.example.mediumspringwebflux.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class Signup {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Signup(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<Void> execute(SignupRequest request) {
        return userRepository.findByEmail(request.email())
                .flatMap(user -> Mono.error(new RuntimeException("유저가 이미 존재")))
                .switchIfEmpty(Mono.defer(() -> {
                    final String password =
                }))
    }

}
