package com.example.mediumspringwebmvc.domain.article.dto

import com.example.mediumspringwebmvc.domain.user.model.User

data class ArticleResponse(
    val id: Long?,
    val user: User,
    val title: String,
    val description: String
)
