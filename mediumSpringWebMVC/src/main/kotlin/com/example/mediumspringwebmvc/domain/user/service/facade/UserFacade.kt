package com.example.mediumspringwebmvc.domain.user.service.facade

import com.example.mediumspringwebmvc.domain.user.model.User
import com.example.mediumspringwebmvc.domain.user.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getUser(): User {
        val authentication = SecurityContextHolder.getContext().authentication
        val email = authentication.name

        return userRepository.findByEmail(email) ?: throw RuntimeException("유저를 찾지 못함")
    }

}