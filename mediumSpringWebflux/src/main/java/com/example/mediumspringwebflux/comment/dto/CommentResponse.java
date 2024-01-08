package com.example.mediumspringwebflux.comment.dto;

import com.example.mediumspringwebflux.comment.document.Comment;
import lombok.Builder;

@Builder
public record CommentResponse(
        String id,
        String comment
) {
    public CommentResponse(Comment comment) {
        this(comment.getId(), comment.getComment());
    }

}
