package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.service.Facade.BoardToBoardResponse;
import com.example.mediumspringwebflux.board.service.Facade.FindBoard;
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
