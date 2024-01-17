package com.example.mediumspringwebmvc.domain.comment.model

import com.example.mediumspringwebmvc.domain.article.model.Article
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var content: String,

    @ManyToOne
    @JoinColumn(name = "article_id")
    val article: Article

) {
}