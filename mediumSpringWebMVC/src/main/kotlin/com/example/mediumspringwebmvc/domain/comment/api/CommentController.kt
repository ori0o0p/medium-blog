package com.example.mediumspringwebmvc.domain.comment.api

import com.example.mediumspringwebmvc.domain.comment.dto.CommentRequest
import com.example.mediumspringwebmvc.domain.comment.service.CreateComment
import com.example.mediumspringwebmvc.domain.comment.service.DeleteComment
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/comments")
class CommentController(
    private val createComment: CreateComment,
    private val deleteComment: DeleteComment
) {

    @PostMapping
    fun create(@RequestBody request: CommentRequest) = createComment.execute(request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = deleteComment.execute(id)

}