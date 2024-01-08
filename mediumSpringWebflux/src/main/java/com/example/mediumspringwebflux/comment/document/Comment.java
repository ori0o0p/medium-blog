package com.example.mediumspringwebflux.comment.document;

import com.example.mediumspringwebflux.board.document.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String boardId;

    @Builder
    public Comment(String comment, String boardId) {
        this.comment = comment;
        this.boardId = boardId;
    }

}
