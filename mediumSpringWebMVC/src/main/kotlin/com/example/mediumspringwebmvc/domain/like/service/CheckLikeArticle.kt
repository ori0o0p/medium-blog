package com.example.mediumspringwebmvc.domain.like.service

import com.example.mediumspringwebmvc.domain.article.service.facade.FindArticle
import com.example.mediumspringwebmvc.domain.like.repository.LikeRepository
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CheckLikeArticle(
    private val likeRepository: LikeRepository,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
) {

    fun execute(id: Long): Boolean {
        val user = userFacade.getUser()
        val article = findArticle.findById(id)

        likeRepository.findByArticleAndUser(article, user) ?: return false

        return true
    }

}