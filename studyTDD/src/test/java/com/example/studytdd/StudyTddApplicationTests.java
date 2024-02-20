package com.example.studytdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
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


@SpringBootTest
public class StudyTddApplicationTests {
    @Autowired
    private WebClient webCilent;

    @Test
    void testGet() {
        SearchResult response = webCilent.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", "마트")
                        .queryParam("display", 5)
                        .queryParam("start", 1)
                        .queryParam("sort", "random")
                        .build())
                .retrieve()
                .bodyToMono(SearchResult.class)
                .block();

        System.out.println(response);
    }

}

record SearchResult(String lastBuildDate, String total, String start, String display, List<Item> items) {
}

record Item(String title, String link, String category, String description, String telephone, String address,
            String roadAddress, String mapx, String map) {
}
