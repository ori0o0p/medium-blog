package com.example.mediumspringwebflux.board.document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
