package com.example.mediumspringwebmvc.domain.article.model

import com.example.mediumspringwebmvc.domain.article.dto.ArticleRequest
import com.example.mediumspringwebmvc.domain.article.dto.ArticleResponse
import com.example.mediumspringwebmvc.domain.comment.model.Comment
import com.example.mediumspringwebmvc.domain.like.model.Like
import com.example.mediumspringwebmvc.domain.user.model.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDate

@Entity
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    var description: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    val createdDate: LocalDate,

    var updatedDate: LocalDate,

    @OneToMany(mappedBy = "article", cascade = [CascadeType.ALL])
    var comments: List<Comment>,

    @OneToMany(mappedBy = "article", cascade = [CascadeType.ALL])
    var likes: List<Like>

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