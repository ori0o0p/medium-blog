package com.example.mediumspringwebmvc.domain.like.repository

import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.like.model.Like
import com.example.mediumspringwebmvc.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository: JpaRepository<Like, Long> {

    fun findByArticleAndUser(article: Article, user: User): Like?
}