package com.example.mediumspringwebmvc.domain.article.component.service

import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import com.example.mediumspringwebmvc.domain.article.component.ArticleComponent
import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
abstract class DeleteArticle(
    private val articleRepository: ArticleRepository,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
): ArticleComponent() {

    @Transactional
    override fun delete(id: Long) {
        val user = userFacade.getUser()
        val article = findArticle.findById(id)

        if (user != article.writer) {
            throw RuntimeException("유저 정보가 일치하지 않음")
        }

        articleRepository.delete(article)
    }

}