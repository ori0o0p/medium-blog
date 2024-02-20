package com.example.studytdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

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
