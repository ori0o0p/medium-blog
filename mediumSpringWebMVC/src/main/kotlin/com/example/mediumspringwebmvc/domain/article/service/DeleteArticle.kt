package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteArticle(
    private val articleRepository: ArticleRepository,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(id: Long) {
        val user = userFacade.getUser()
        val article = findArticle.findById(id)

        if (user != article.writer) {
            throw RuntimeException("유저 정보가 일치하지 않음")
        }

        articleRepository.delete(article)
    }

}