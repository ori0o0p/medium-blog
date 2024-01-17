package com.example.mediumspringwebmvc.domain.article.api

import com.example.mediumspringwebmvc.domain.article.service.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/articles")
class ArticleController(
    private val createArticle: CreateArticle,
    private val findByIdArticle: FindByIdArticle,
    private val findAllArticle: FindAllArticle,
    private val updateArticle: UpdateArticle,
    private val deleteArticle: DeleteArticle
) {
    
    fun create() {}

    fun findAll() {}

    fun findById() {}

    fun update() {}

    fun delete() {}

}