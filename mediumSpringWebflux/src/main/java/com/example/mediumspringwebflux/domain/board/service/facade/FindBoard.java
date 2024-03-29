package com.example.mediumspringwebflux.domain.board.service.facade;

import com.example.mediumspringwebflux.domain.board.document.Board;
import com.example.mediumspringwebflux.domain.board.repository.BoardRepository;
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
