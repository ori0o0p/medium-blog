package com.example.mediumspringwebmvc.domain.like.repository

import com.example.mediumspringwebmvc.domain.like.model.Like
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository: JpaRepository<Like, Long> {
}