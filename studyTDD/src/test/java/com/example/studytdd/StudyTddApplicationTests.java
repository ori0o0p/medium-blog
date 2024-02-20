package com.example.studytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;
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
    private NaverSearchAPI naverSearchAPI;

    @Test
    void testGet() {
        SearchResult result = naverSearchAPI.search();
        Assertions.assertEquals(result.items().size(), 5);
    }


}

record SearchResult(String lastBuildDate, String total, String start, String display, List<Item> items) {
}

record Item(String title, String link, String category, String description, String telephone, String address,
            String roadAddress, String mapx, String map) {
}
