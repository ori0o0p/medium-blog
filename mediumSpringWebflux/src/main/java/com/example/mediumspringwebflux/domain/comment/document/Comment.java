package com.example.mediumspringwebflux.domain.comment.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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
