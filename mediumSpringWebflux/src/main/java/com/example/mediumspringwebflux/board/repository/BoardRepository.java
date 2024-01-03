package com.example.mediumspringwebflux.board.repository;

import com.example.mediumspringwebflux.board.document.Board;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BoardRepository extends ReactiveMongoRepository<Board, String> {
}
