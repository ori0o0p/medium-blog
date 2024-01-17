package com.example.mediumspringwebmvc.domain.article.dto

import com.example.mediumspringwebmvc.domain.comment.dto.CommentResponse
import com.example.mediumspringwebmvc.domain.user.model.User

data class ArticleDetailResponse(
    val id: Long?,
    val writer: User,
    val title: String,
    val description: String,
    val comments: List<CommentResponse>

)
