package com.example.mediumspringwebmvc.domain.comment.dto

import com.example.mediumspringwebmvc.domain.user.model.User

data class CommentResponse(
    val id: Long?,
    val writer: User,
    val content: String

)
