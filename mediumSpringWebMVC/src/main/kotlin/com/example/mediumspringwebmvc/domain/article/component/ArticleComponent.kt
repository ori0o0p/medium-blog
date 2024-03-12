package com.example.mediumspringwebmvc.domain.article.component

import com.example.mediumspringwebmvc.domain.article.dto.ArticleDetailResponse
import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse

abstract class ArticleComponent {

    abstract fun create(request: ArticleRequest)
    abstract fun delete(id: Long)
    abstract fun findAll(): List<ArticleResponse>
    abstract fun findById(id: Long): ArticleDetailResponse
    abstract fun update(id: Long, request: ArticleRequest)
}