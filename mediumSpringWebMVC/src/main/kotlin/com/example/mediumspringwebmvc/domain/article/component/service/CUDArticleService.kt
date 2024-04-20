package com.example.mediumspringwebmvc.domain.article.component.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import com.example.mediumspringwebmvc.domain.article.component.CUDArticleComponent
import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class CUDArticleService(
    private val articleRepository: ArticleRepository,
    private val userFacade: UserFacade,
    private val findArticle: FindArticle
) : CUDArticleComponent {

    @Transactional
    override fun create(request: ArticleRequest) {
        val user = userFacade.getUser()

        val article = Article(
            title = request.title,
            description = request.description,
            writer = user
        )

        articleRepository.save(article)
    }

    @Transactional
    override fun delete(id: Long) {
        val user = userFacade.getUser()
        val article = findArticle.findById(id)

        article.writer.let {
            if (it != user) {
                throw RuntimeException("유저 정보가 일치하지 않음")
            }
        }

        articleRepository.delete(article)
    }

    @Transactional
    override fun update(id: Long, request: ArticleRequest) {
        val article = findArticle.findById(id)

        article.edit(request)
    }

}