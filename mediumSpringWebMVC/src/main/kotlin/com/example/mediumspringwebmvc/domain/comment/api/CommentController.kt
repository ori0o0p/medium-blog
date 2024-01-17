package com.example.mediumspringwebmvc.domain.comment.api

import com.example.mediumspringwebmvc.domain.comment.service.CreateComment
import com.example.mediumspringwebmvc.domain.comment.service.DeleteComment
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController(
    private val createComment: CreateComment,
    private val deleteComment: DeleteComment
) {
}