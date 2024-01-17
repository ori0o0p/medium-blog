package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleDetailResponse
import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FindByIdArticle(
    private val findArticle: FindArticle
) {

    @Transactional(readOnly = true)
    fun execute(id: Long): ArticleDetailResponse {
        val article = findArticle.findById(id)
        val commentResponses = article.comments.map { it.toCommentResponse() }

        return ArticleDetailResponse(
            id = article.id,
            title = article.title,
            description = article.description,
            comments = commentResponses
        )
    }

}