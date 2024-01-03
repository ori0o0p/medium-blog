package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class FindAllBoard {
    private final BoardRepository boardRepository;

    public FindAllBoard(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Flux<BoardResponse> execute() {
        return boardRepository.findAll()
                .flatMap(this::rapping)
                .subscribeOn(Schedulers.boundedElastic());
    }

    private Mono<BoardResponse> rapping(Board board) {
        return Mono.fromCallable(() -> BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .description(board.getDescription())
                .build());
    }

}
