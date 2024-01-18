package com.example.mediumspringwebmvc.global.config

import com.example.mediumspringwebmvc.global.security.JwtFilter
import com.example.mediumspringwebmvc.global.security.Tokenizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val tokenizer: Tokenizer
) {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.csrf { csrf -> csrf.disable() }
            .formLogin { formLogin -> formLogin.disable() }
            .headers { header -> header.frameOptions { frameOptions -> frameOptions.disable() } }
            .sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth -> auth
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated() }
            .addFilterBefore(JwtFilter(tokenizer), UsernamePasswordAuthenticationFilter::class.java)
        return httpSecurity.build()
    }


}