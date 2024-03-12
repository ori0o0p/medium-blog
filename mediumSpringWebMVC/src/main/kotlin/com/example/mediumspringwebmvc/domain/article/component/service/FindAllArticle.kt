package com.example.mediumspringwebmvc.domain.article.component.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import com.example.mediumspringwebmvc.domain.article.component.ArticleComponent
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
abstract class FindAllArticle(
    private val articleRepository: ArticleRepository
): ArticleComponent() {

    @Transactional(readOnly = true)
    override fun findAll(): List<ArticleResponse> {
        val articles = articleRepository.findAll()

        return articles.map { it.toArticleResponse() }
    }

}