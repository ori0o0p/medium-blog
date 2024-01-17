package com.example.mediumspringwebmvc.global.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter(
    private val tokenizer: Tokenizer
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = extractToken(request)

        if (StringUtils.hasText(token) && tokenizer.verifyToken(token)) {
            val authentication = tokenizer.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = authentication
        }

        return filterChain.doFilter(request, response)
    }

    private fun extractToken(request: HttpServletRequest): String? {
        val token = request.getHeader(HttpHeaders.AUTHORIZATION)

        if (token.startsWith("Bearer ")) {
            return token.substring(7)
        }

        return null
    }

}