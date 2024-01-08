package com.example.mediumspringwebflux.board.dto;

import com.example.mediumspringwebflux.comment.dto.CommentResponse;
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
