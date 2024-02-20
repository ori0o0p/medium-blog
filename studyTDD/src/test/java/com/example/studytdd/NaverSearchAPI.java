package com.example.studytdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class WebClientConfig {

    private String id = System.getenv().get("NAVER_ID");

    private String secret = System.getenv().get("NAVER_SECRET");

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://openapi.naver.com/v1/search/local.json")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Naver-Client-Id", id)
                .defaultHeader("X-Naver-Client-Secret", secret)
                .build();
    }

}

@Component
public class NaverSearchAPI {
    @Autowired
    WebClient webClient;

    public SearchResult search() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", "마트")
                        .queryParam("display", 5)
                        .queryParam("start", 1)
                        .queryParam("sort", "random")
                        .build())
                .retrieve()
                .bodyToMono(SearchResult.class)
                .block();
    }

}
