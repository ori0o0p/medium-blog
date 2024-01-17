package com.example.mediumspringwebmvc.domain.comment.dto

import lombok.NonNull

data class CommentRequest(
    @NonNull
    val articleId: Long,
    val content: String
)
