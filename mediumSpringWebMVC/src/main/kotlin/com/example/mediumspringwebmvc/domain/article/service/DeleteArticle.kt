package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DeleteArticle(
    private val articleRepository: ArticleRepository
) {

    fun execute(id: Long) {
        val article = articleRepository.findByIdOrNull(id) ?: throw RuntimeException("게시물을 찾지 못함")

        articleRepository.delete(article)
    }

}