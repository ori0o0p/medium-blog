package com.example.mediumspringwebmvc.global.security

import io.jsonwebtoken.*
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class Tokenizer {

    companion object {
        private const val SECRET = "secret"
    }

    fun generateToken(email: String): String {
        val calender = Calendar.getInstance()
        calender.add(Calendar.HOUR, 2)
        val expiresAt = calender.time

        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(expiresAt)
            .compact()
    }

    fun verifyToken(token: String?): Boolean {
        try {
            parse(token)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    private fun parse(token: String?): Jws<Claims> {
        return Jwts.parser().setSigningKey(SECRET)
            .parseClaimsJws(token)
    }

    fun getAuthentication(token: String?): Authentication {
        val claims =
    }

    private fun createUserByClaims(claims: Claims): UserDetails {
        val subject = claims.subject
        return User(subject, "", Collections.emptyList())
    }

}