package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CreateArticle(
    private val articleRepository: ArticleRepository
) {

    fun execute(request: ArticleRequest) {
        val article = Article(
            title = request.title,
            description = request.description,
            createdDate = LocalDate.now())

        articleRepository.save(article)
    }

}