package com.example.mediumspringwebflux.board.service.Facade;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.repository.BoardRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class FindBoard {
    private final BoardRepository boardRepository;

    public FindBoard(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Mono<Board> execute(String id) {
        return boardRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("게시물을 찾지 못함")));
    }

}
