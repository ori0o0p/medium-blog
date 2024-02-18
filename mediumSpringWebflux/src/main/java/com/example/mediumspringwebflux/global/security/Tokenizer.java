package com.example.mediumspringwebflux.global.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

@Component
public class Tokenizer {

    private static final String SECRET = "secret";

    public String createToken(String user) {
        return tokenize(user, "access");
    }

    private String tokenize(String user, String type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
        Date expiresAt = calendar.getTime();

        Claims claims = Jwts.claims()
                .setSubject(user);
        claims.put("type", type);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("url")
                .setExpiration(expiresAt)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    private Mono<Jws<Claims>> parse(String token) {
        return Mono.fromCallable(() -> Jwts.parser().setSigningKey(SECRET)
                        .parseClaimsJws(token))
                .onErrorMap(e -> new RuntimeException());
    }

    private Mono<Claims> parseClaims(String token) {
        return parse(token)
                .map(Jwt::getBody);
    }

    private UserDetails createAuthenticatedUserFromClaims(Claims claims) {
        String subject = claims.getSubject();
        return new User(subject, "", Collections.emptyList());
    }

    public Mono<Authentication> getAuthentication(String token) {
        return parseClaims(token)
                .map(this::createAuthenticatedUserFromClaims)
                .map(details -> new UsernamePasswordAuthenticationToken(
                        details, null, details.getAuthorities()));
    }



}
