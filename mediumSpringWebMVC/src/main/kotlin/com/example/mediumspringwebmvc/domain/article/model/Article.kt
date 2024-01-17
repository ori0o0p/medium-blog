package com.example.mediumspringwebmvc.domain.article.model

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.comment.model.Comment
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDate

@Entity
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    var description: String,

    val createdDate: LocalDate,

    var updatedDate: LocalDate,

    @OneToMany(mappedBy = "article", cascade = [CascadeType.ALL])
    var comments: List<Comment>

) {

    fun edit(request: ArticleRequest) {
        title = request.title
        description = request.description
        updatedDate = LocalDate.now()
    }

    fun toArticleResponse(): ArticleResponse = ArticleResponse(
        id = id,
        title = title,
        description = description
    )

}