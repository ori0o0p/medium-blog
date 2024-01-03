package com.example.mediumspringwebflux.board.service.Facade;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.dto.BoardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BoardToBoardResponse {

    public Mono<BoardResponse> rapping(Board board) {
        return Mono.fromCallable(() -> BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .description(board.getDescription())
                .build());
    }

}
