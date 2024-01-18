package com.example.mediumspringwebmvc.domain.like.service.facade

import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import com.example.mediumspringwebmvc.domain.like.model.Like
import com.example.mediumspringwebmvc.domain.like.repository.LikeRepository
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Component

@Component
class FindLike(
    private val likeRepository: LikeRepository,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
) {

    fun findById(articleId: Long): Like? {
        val user = userFacade.getUser()
        val article = findArticle.findById(articleId)

        return likeRepository.findByArticleAndUser(article, user)
    }

}