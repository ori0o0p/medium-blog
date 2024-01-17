package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import org.springframework.stereotype.Service

@Service
class FindByIdArticle(
    private val findArticle: FindArticle
) {

    fun execute(id: Long): ArticleResponse {
        val article = findArticle.findById(id)

        return article.toArticleResponse()
    }

}