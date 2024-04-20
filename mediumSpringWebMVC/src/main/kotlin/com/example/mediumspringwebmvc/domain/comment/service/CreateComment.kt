package com.example.mediumspringwebmvc.domain.comment.service

import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import com.example.mediumspringwebmvc.domain.comment.dto.CommentRequest
import com.example.mediumspringwebmvc.domain.comment.model.Comment
import com.example.mediumspringwebmvc.domain.comment.repository.CommentRepository
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class CreateComment(
    private val commentRepository: CommentRepository,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: CommentRequest) {
        val user = userFacade.getUser()
        val article = findArticle.findById(request.articleId)

        val comment = Comment(
            content = request.content,
            article = article,
            writer = user,
            createdDate = LocalDate.now())

        commentRepository.save(comment)
    }

}