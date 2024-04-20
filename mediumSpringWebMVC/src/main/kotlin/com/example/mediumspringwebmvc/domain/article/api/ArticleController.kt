package com.example.mediumspringwebmvc.domain.article.api

import com.example.mediumspringwebmvc.domain.article.dto.ArticleDetailResponse
import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.article.component.*
import org.springframework.web.bind.annotation.DeleteMapping
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
    private val cudArticleComponent: CUDArticleComponent,
    private val readArticleComponent: ReadArticleComponent
) {

    @PostMapping
    fun create(@RequestBody request: ArticleRequest) = cudArticleComponent.create(request)

    @GetMapping
    fun findAll(): List<ArticleResponse> = readArticleComponent.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ArticleDetailResponse = readArticleComponent.findById(id)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: ArticleRequest) =
        cudArticleComponent.update(id, request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = cudArticleComponent.delete(id)
}