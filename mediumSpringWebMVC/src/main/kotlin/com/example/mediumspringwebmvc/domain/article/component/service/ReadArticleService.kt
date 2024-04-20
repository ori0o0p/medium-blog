package com.example.mediumspringwebmvc.domain.article.component.service

import com.example.mediumspringwebmvc.domain.article.component.ReadArticleComponent
import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import com.example.mediumspringwebmvc.domain.article.dto.ArticleDetailResponse
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReadArticleService(
    private val articleRepository: ArticleRepository,
    private val findArticle: FindArticle
): ReadArticleComponent {

    @Transactional(readOnly = true)
    override fun findAll(): List<ArticleResponse> {
        val articles = articleRepository.findAll()

        return articles.map { it.toArticleResponse() }
    }

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