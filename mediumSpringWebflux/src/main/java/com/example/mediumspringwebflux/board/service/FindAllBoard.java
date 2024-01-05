package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.repository.BoardRepository;
import com.example.mediumspringwebflux.board.service.facade.BoardToBoardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class FindAllBoard {
    private final BoardRepository boardRepository;
    private final BoardToBoardResponse boardToBoardResponse;

    public FindAllBoard(BoardRepository boardRepository, BoardToBoardResponse boardToBoardResponse) {
        this.boardRepository = boardRepository;
        this.boardToBoardResponse = boardToBoardResponse;
    }

    public Flux<BoardResponse> execute() {
        return boardRepository.findAll()
                .flatMap(boardToBoardResponse::rapping)
                .subscribeOn(Schedulers.boundedElastic());
    }

}
