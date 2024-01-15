package com.example.mediumspringwebclientexternalapi.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Slf4j
@Service
public class WebClientService {

    @Value("${app.baseUrl}")
    private static String URL;

    public void get() {
        WebClient webClient = WebClient
                .builder()
                .baseUrl(URL)
                .build();

        Object response = webClient
                .get()
                .uri("/api")
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        log.info(response.toString());
    }

}
