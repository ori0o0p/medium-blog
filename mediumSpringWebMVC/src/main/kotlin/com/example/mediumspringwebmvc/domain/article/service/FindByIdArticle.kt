package com.example.mediumspringwebmvc.domain.article.service

import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.repository.ArticleRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class FindByIdArticle(
    private val articleRepository: ArticleRepository
) {

    fun execute(id: Long): ArticleResponse? {
        val article = articleRepository.findById(id).getOrNull()

        return article?.toArticleResponse()
    }

}