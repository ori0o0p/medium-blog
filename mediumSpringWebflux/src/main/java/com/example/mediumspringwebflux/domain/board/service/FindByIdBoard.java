package com.example.mediumspringwebflux.domain.board.service;

import com.example.mediumspringwebflux.domain.board.dto.BoardResponse;
import com.example.mediumspringwebflux.domain.board.service.facade.BoardToBoardResponse;
import com.example.mediumspringwebflux.domain.board.service.facade.FindBoard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindByIdBoard {
    private final BoardToBoardResponse boardToBoardResponse;
    private final FindBoard findBoard;

    public FindByIdBoard(BoardToBoardResponse boardToBoardResponse, FindBoard findBoard) {
        this.boardToBoardResponse = boardToBoardResponse;
        this.findBoard = findBoard;
    }

    public Mono<BoardResponse> execute(String id) {
        return Mono.defer(() -> findBoard.execute(id)
                .flatMap(boardToBoardResponse::rapping));
    }

}
