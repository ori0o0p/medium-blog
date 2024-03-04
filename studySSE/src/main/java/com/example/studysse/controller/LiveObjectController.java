package com.example.studysse.controller;

import com.example.studysse.model.LiveObject;
import com.example.studysse.service.LiveObjectHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class LiveObjectController {
    private final LiveObjectHandler handler;

    @PostMapping("/live-send")
    public Mono<LiveObject> send(@RequestBody LiveObject object) {
        handler.publish(object);
        return Mono.just(object);
    }

    @GetMapping(path = "/live-object", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> consumer() {
        return Flux.create(s -> handler.subscribe(s::next))
                .map(object -> ServerSentEvent.builder()
                        .data(object)
                        .event("!!")
                        .build());
    }

    @GetMapping("/str")
    public Flux<ServerSentEvent<String>> getStr() {
        Mono<String> data_1 = Mono.just("first");
        Mono<String> data_2 = Mono.just("second");

        return Flux.concat(
                data_1.map(data -> ServerSentEvent.<String>builder().data(data).build()),
                data_2.delayElement(Duration.ofSeconds(10)).map(data -> ServerSentEvent.<String>builder().data(data).build())
        );
    }

}
