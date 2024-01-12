package com.example.mediumspringwebflux.domain.comment.dto;

import lombok.NonNull;

public record CommentRequest(
        @NonNull
        String boardId,
        @NonNull
        String comment
) {
}
