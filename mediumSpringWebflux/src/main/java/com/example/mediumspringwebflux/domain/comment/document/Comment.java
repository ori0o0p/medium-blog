package com.example.mediumspringwebflux.domain.comment.document;

import com.example.mediumspringwebflux.domain.user.document.User;
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

    private User writer;

    @JsonIgnore
    private String boardId;

    @Builder
    public Comment(String comment, User writer, String boardId) {
        this.comment = comment;
        this.writer = writer;
        this.boardId = boardId;
    }

}
