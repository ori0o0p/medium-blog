package com.example.mediumspringwebflux.board.service.facade;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.dto.BoardResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BoardToBoardResponse {

    public Mono<BoardResponse> rapping(Board board) {
        return Mono.fromCallable(() -> BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .description(board.getDescription())
                .build());
    }

}
