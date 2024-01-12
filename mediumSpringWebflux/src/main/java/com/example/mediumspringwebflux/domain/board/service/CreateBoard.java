package com.example.mediumspringwebflux.domain.board.service;

import com.example.mediumspringwebflux.domain.board.dto.BoardRequest;
import com.example.mediumspringwebflux.domain.board.document.Board;
import com.example.mediumspringwebflux.domain.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateBoard {
    private final BoardRepository boardRepository;

    public CreateBoard(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Mono<Void> execute(BoardRequest request) {
        return Mono.just(Board.builder()
                        .title(request.title())
                        .description(request.description())
                        .build())
                .flatMap(boardRepository::save)
                .then();
    }

}
