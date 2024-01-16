package com.example.mediumspringwebflux.global.security;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtWebFilter implements WebFilter {
    private final Tokenizer tokenizer;

    public JwtWebFilter(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = extractToken(exchange);

        if (StringUtils.hasText(token) && tokenizer.verify(token)) {
            
        }

        return null;
    }

    private String extractToken(ServerWebExchange exchange) {
        return exchange.getRequest().getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION)
                .substring(7);
    }

}
