package com.example.mediumspringwebmvc.domain.article.repository

import com.example.mediumspringwebmvc.domain.article.model.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article, Long> {
}