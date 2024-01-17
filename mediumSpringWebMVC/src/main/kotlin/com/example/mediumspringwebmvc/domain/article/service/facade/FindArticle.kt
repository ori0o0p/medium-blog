package com.example.mediumspringwebmvc.domain.article.service.facade

import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FindArticle(
    private val articleRepository: ArticleRepository
) {

    fun findById(id: Long): Article =
        articleRepository.findByIdOrNull(id) ?: throw RuntimeException("게시물을 찾지 못함")

}