package com.example.mediumspringwebmvc.domain.comment.service

import com.example.mediumspringwebmvc.domain.comment.repository.CommentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteComment(
    private val commentRepository: CommentRepository
) {

    @Transactional
    fun execute(id: Long) {
        val comment = commentRepository.findByIdOrNull(id) ?: throw RuntimeException("댓글을 찾지 못함")

        commentRepository.delete(comment)
    }

}