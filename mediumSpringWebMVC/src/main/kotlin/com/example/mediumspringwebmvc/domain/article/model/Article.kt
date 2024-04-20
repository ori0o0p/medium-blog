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
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate

@Entity
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    var description: String,

    @ManyToOne
    @JoinColumn(name = "writer_id")
    val writer: User,

    @CreationTimestamp
    var createdDate: LocalDate? = null,

    @UpdateTimestamp
    var updatedDate: LocalDate? = null,

    @OneToMany(mappedBy = "article", cascade = [CascadeType.ALL])
    var comments: MutableList<Comment> = mutableListOf(),
) {

    fun edit(request: ArticleRequest) {
        title = request.title
        description = request.description
        updatedDate = LocalDate.now()
    }

    companion object {
        fun toArticleResponse(article: Article): ArticleResponse {
            return ArticleResponse(
                id = article.id,
                writer = article.writer,
                title = article.title,
                description = article.description
            )
        }
    }

}