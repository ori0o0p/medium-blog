package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class FindByIdArticle(
    private val articleRepository: ArticleRepository
) {

    fun execute(id: Long): ArticleResponse {
        val article = articleRepository.findByIdOrNull(id) ?: throw RuntimeException("게시물을 찾지 못함")

        return article.toArticleResponse()
    }

}