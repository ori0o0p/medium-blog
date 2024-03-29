package com.example.studytdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

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

    public SearchResult search(SearchRequest request) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", request.query())
                        .queryParam("display", request.display())
                        .queryParam("start", request.start())
                        .queryParam("sort", request.sort())
                        .build())
                .retrieve()
                .bodyToMono(SearchResult.class)
                .block();
    }

}

record SearchRequest(String query, Integer display, Integer start, String sort) {
}

record SearchResult(String lastBuildDate, String total, String start, String display, List<Item> items) {
}

record Item(String title, String link, String category, String description, String telephone, String address,
            String roadAddress, String mapx, String map) {
}