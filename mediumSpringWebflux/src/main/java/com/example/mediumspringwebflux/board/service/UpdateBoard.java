package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.dto.BoardRequest;
import com.example.mediumspringwebflux.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateBoard {
    private final BoardRepository boardRepository;

    public UpdateBoard(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Mono<Void> execute(String id, BoardRequest request) {
        return Mono.defer(() -> boardRepository.findById(id)
                .flatMap(board -> {
                    board.edit(request.title(), request.description());
                    return boardRepository.save(board);
                })
                .switchIfEmpty(Mono.error(new Exception("게시물을 찾지 못함")))).then();
    }

}
