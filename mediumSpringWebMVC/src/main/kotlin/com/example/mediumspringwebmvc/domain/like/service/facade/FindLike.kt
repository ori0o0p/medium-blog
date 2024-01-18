package com.example.mediumspringwebmvc.domain.like.service.facade

import com.example.mediumspringwebmvc.domain.article.model.Article
import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import com.example.mediumspringwebmvc.domain.like.model.Like
import com.example.mediumspringwebmvc.domain.like.repository.LikeRepository
import com.example.mediumspringwebmvc.domain.user.model.User
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class FindLike(
    private val likeRepository: LikeRepository,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
) {

    fun findById(articleId: Long): Like? {
        val user = userFacade.getUser()
        return findByIdAndUser(articleId, user)
    }

    fun findByIdAndUser(articleId: Long, user: User): Like? {
        val article = findArticle.findById(articleId)

        return findByArticleAndUser(article, user)
    }

    fun findByArticleAndUser(article: Article, user: User): Like? {
        return likeRepository.findByArticleAndUser(article, user)
    }

}