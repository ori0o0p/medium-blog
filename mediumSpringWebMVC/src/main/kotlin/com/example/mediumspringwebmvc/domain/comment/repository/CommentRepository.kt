package com.example.mediumspringwebmvc.domain.comment.repository

import com.example.mediumspringwebmvc.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}