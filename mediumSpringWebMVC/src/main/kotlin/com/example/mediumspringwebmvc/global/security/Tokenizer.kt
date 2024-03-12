package com.example.mediumspringwebmvc.global.security

import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
        return try {
            parse(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun parse(token: String?): Jws<Claims> {
        return Jwts.parser().setSigningKey(SECRET)
            .parseClaimsJws(token)
    }

    private fun parseClaims(token: String?): Claims {
        return parse(token).body
    }

    fun getAuthentication(token: String?): Authentication {
        val claims = parseClaims(token)
        val userDetails = createUserByClaims(claims)

        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    private fun createUserByClaims(claims: Claims): UserDetails {
        val subject = claims.subject
        return User(subject, "", Collections.emptyList())
    }

}