package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class CreateArticle(
    private val articleRepository: ArticleRepository,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: ArticleRequest) {
        val user = userFacade.getUser()

        val article = Article(
            title = request.title,
            description = request.description,
            user = user,
            createdDate = LocalDate.now(),
            updatedDate = LocalDate.now(),
            comments = ArrayList(),
            likes = ArrayList())

        articleRepository.save(article)
    }

}