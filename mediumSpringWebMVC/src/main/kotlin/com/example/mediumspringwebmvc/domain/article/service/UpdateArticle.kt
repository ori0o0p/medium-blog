package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import org.springframework.stereotype.Service

@Service
class UpdateArticle(
    private val findArticle: FindArticle
) {

    fun execute(id: Long, request: ArticleRequest) {
        val article = findArticle.findById(id)

        article.edit(request)
    }

}