package com.example.mediumspringwebmvc.domain.article.component.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.component.ArticleComponent
import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
abstract class UpdateArticle(
    private val findArticle: FindArticle
): ArticleComponent() {

    @Transactional
    override fun update(id: Long, request: ArticleRequest) {
        val article = findArticle.findById(id)

        article.edit(request)
    }

}