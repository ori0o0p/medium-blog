package com.example.mediumspringwebflux.domain.user.repository;

import com.example.mediumspringwebflux.domain.user.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
