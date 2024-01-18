package com.example.mediumspringwebmvc.domain.like.service

import com.example.mediumspringwebmvc.domain.like.service.facade.FindLike
import org.springframework.stereotype.Service

@Service
class CheckLikeArticle(
    private val findLike: FindLike
) {

    fun execute(id: Long): Boolean {
        findLike.findById(id) ?: return false

        return true
    }

}