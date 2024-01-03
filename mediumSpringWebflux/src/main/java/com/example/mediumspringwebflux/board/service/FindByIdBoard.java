package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.repository.BoardRepository;
import com.example.mediumspringwebflux.board.service.Facade.BoardToBoardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindByIdBoard {
    private final BoardRepository boardRepository;
    private final BoardToBoardResponse boardToBoardResponse;

    public FindByIdBoard(BoardRepository boardRepository, BoardToBoardResponse boardToBoardResponse) {
        this.boardRepository = boardRepository;
        this.boardToBoardResponse = boardToBoardResponse;
    }

    public Mono<BoardResponse> execute(String id) {
        return boardRepository.findById(id)
                .flatMap(boardToBoardResponse::rapping)
                .switchIfEmpty(Mono.error(new Exception("게시물을 찾지 못함")));
    }

}
