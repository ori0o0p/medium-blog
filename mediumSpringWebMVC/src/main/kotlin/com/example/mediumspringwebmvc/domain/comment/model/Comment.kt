package com.example.mediumspringwebmvc.domain.comment.model

import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.comment.dto.CommentResponse
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var content: String,

    @ManyToOne
    @JoinColumn(name = "article_id")
    val article: Article,

    val createdDate: LocalDate

) {

    fun toCommentResponse(): CommentResponse = CommentResponse(
        id = id,
        content = content
    )

}