package com.example.mediumspringwebmvc.domain.comment.api

import com.example.mediumspringwebmvc.domain.comment.service.CreateComment
import com.example.mediumspringwebmvc.domain.comment.service.DeleteComment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/comments")
class CommentController(
    private val createComment: CreateComment,
    private val deleteComment: DeleteComment
) {

    fun create() {}

    fun delete() {}

}