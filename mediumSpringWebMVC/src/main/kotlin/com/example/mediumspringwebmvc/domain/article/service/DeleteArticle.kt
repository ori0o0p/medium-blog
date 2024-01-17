package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import org.springframework.stereotype.Service

@Service
class DeleteArticle(
    private val articleRepository: ArticleRepository,
    private val findArticle: FindArticle
) {

    fun execute(id: Long) {
        val article = findArticle.findById(id)

        articleRepository.delete(article)
    }

}