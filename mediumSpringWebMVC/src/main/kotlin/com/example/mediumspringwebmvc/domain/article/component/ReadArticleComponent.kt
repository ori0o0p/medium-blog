package com.example.mediumspringwebmvc.domain.article.component

import com.example.mediumspringwebmvc.domain.article.dto.ArticleDetailResponse
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse

interface ReadArticleComponent {
    fun findAll(): List<ArticleResponse>
    fun findById(id: Long): ArticleDetailResponse

}