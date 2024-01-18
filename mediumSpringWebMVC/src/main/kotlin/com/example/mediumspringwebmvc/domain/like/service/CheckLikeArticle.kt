package com.example.mediumspringwebmvc.domain.like.service

import com.example.mediumspringwebmvc.domain.like.service.facade.FindLike
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CheckLikeArticle(
    private val findLike: FindLike
) {

    @Transactional(readOnly = true)
    fun execute(id: Long): Boolean {
        findLike.findById(id) ?: return false

        return true
    }

}