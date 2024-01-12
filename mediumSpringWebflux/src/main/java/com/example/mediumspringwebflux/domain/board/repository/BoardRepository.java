package com.example.mediumspringwebflux.domain.board.repository;

import com.example.mediumspringwebflux.domain.board.document.Board;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BoardRepository extends ReactiveMongoRepository<Board, String> {
}
