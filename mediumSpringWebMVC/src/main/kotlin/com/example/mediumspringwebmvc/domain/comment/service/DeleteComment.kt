package com.example.mediumspringwebmvc.domain.comment.service

import com.example.mediumspringwebmvc.domain.comment.repository.CommentRepository
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteComment(
    private val commentRepository: CommentRepository,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(id: Long) {
        val user = userFacade.getUser()
        val comment = commentRepository.findByIdOrNull(id) ?: throw RuntimeException("댓글을 찾지 못함")

        if (user != comment.writer) {
            throw RuntimeException("유저 정보가 일치하지 않음")
        }

        commentRepository.delete(comment)
    }

}