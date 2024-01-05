package com.example.mediumspringwebflux.comment.document;

import com.example.mediumspringwebflux.board.document.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@NoArgsConstructor
public class Comment {

    @Id
    private String id;

    private String comment;

    @DBRef(lazy = true)
    private Board board;

    @Builder
    public Comment(String comment, Board board) {
        this.comment = comment;
        this.board = board;
    }

}
