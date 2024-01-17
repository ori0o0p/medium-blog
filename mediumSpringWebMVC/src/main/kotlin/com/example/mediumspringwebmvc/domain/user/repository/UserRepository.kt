package com.example.mediumspringwebmvc.domain.user.repository

import com.example.mediumspringwebmvc.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(email: String): User?
}