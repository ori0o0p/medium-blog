package com.example.mediumspringwebmvc.domain.like.service

import com.example.mediumspringwebmvc.domain.article.component.facade.FindArticle
import com.example.mediumspringwebmvc.domain.like.model.Like
import com.example.mediumspringwebmvc.domain.like.repository.LikeRepository
import com.example.mediumspringwebmvc.domain.like.service.facade.FindLike
import com.example.mediumspringwebmvc.domain.user.service.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeToggle(
    private val likeRepository: LikeRepository,
    private val findLike: FindLike,
    private val findArticle: FindArticle,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(articleId: Long) {
        val user = userFacade.getUser()
        val article = findArticle.findById(articleId)

        val like = findLike.findByArticleAndUser(article, user)

        if (like == null) {
            likeRepository.save(Like(
                article = article,
                user = user
            ))
        } else {
            likeRepository.delete(like)
        }
    }

}