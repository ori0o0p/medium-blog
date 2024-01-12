package com.example.mediumspringwebflux.domain.board.dto;

import com.example.mediumspringwebflux.domain.comment.dto.CommentResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record BoardResponse(
        String id,
        String title,
        String description,
        List<CommentResponse> comments
) {
}
