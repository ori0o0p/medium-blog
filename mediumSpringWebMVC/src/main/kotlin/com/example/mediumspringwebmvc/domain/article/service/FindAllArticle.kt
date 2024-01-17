package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FindAllArticle(
    private val articleRepository: ArticleRepository
) {

    @Transactional(readOnly = true)
    fun execute(): List<ArticleResponse> {
        val articles = articleRepository.findAll()

        return articles.map { it.toArticleResponse() }
    }

}