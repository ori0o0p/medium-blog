package com.example.mediumspringwebmvc.domain.article.component

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest

interface CUDArticleComponent {

    fun create(request: ArticleRequest)
    fun delete(id: Long)
    fun update(id: Long, request: ArticleRequest)

}