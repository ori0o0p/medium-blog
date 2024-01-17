package com.example.mediumspringwebmvc.domain.article.dto

import com.example.mediumspringwebmvc.domain.comment.dto.CommentResponse

data class ArticleResponse(
    val id: Long?,
    val title: String,
    val description: String,
    val comments: List<CommentResponse>
)
