package com.example.mediumspringwebflux.comment.dto;

public record CommentRequest(
        String boardId,
        String comment
) {
}
