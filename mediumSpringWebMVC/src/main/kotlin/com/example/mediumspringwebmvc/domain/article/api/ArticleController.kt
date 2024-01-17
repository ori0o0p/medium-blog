package com.example.mediumspringwebmvc.domain.article.api

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping
    fun create(@RequestBody request: ArticleRequest) = createArticle.execute(request)

    @GetMapping
    fun findAll(): List<ArticleResponse> = findAllArticle.execute()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ArticleResponse = findByIdArticle.execute(id)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: ArticleRequest) =
        updateArticle.execute(id, request)

    fun delete() {}

}