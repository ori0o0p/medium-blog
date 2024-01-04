package com.example.mediumspringwebflux.board.document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

@Getter
@Document
@NoArgsConstructor
public class Board {

    @Id
    private String id;

    private String title;

    private String description;

    @Builder
    public Board(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void edit(String title, String description) {
        this.title = title;
        this.description = description;
    }
//  I/O 작업이 없기 때문에 Mono를 반환할 필요가 없다고 판단
//    public Mono<Void> edit(String title, String description) {
//        return Mono.fromRunnable(() -> {
//            this.title = title;
//            this.description = description;
//        });
//    }

}
