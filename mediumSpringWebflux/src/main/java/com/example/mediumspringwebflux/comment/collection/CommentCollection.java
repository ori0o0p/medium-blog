package com.example.mediumspringwebflux.comment.collection;

import com.example.mediumspringwebflux.comment.document.Comment;
import com.example.mediumspringwebflux.comment.dto.CommentResponse;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

public class CommentCollection {
    private final List<Comment> commentList;

    public CommentCollection(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Flux<CommentResponse> toCommentResponse() {
        return Flux.fromIterable(commentList)
                .filter(Objects::nonNull)
                .map(CommentResponse::new);
    }

}
