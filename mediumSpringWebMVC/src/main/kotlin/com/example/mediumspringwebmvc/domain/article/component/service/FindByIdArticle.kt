package com.example.mediumspringwebmvc.domain.article.component.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleDetailResponse
import com.example.mediumspringwebmvc.domain.article.component.ArticleComponent
import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
abstract class FindByIdArticle(
    private val findArticle: FindArticle
): ArticleComponent() {

    @Transactional(readOnly = true)
    override fun findById(id: Long): ArticleDetailResponse {
        val article = findArticle.findById(id)
        val commentResponses = article.comments.map { it.toCommentResponse() }

        return ArticleDetailResponse(
            id = article.id,
            writer = article.writer,
            title = article.title,
            description = article.description,
            comments = commentResponses
        )
    }

}