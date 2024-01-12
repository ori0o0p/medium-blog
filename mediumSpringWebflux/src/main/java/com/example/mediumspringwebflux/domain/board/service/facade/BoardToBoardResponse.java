package com.example.mediumspringwebflux.domain.board.service.facade;

import com.example.mediumspringwebflux.domain.board.document.Board;
import com.example.mediumspringwebflux.domain.board.dto.BoardResponse;
import com.example.mediumspringwebflux.domain.comment.collection.CommentCollection;
import com.example.mediumspringwebflux.domain.comment.dto.CommentResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BoardToBoardResponse {

    public Mono<BoardResponse> rapping(Board board) {
        CommentCollection commentCollection = new CommentCollection(board.getComments());
        Flux<CommentResponse> commentListFlux = commentCollection.toCommentResponse();

        return commentListFlux.collectList()
                .map(commentList -> BoardResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .description(board.getDescription())
                        .comments(commentList)
                        .build());
    }

}
