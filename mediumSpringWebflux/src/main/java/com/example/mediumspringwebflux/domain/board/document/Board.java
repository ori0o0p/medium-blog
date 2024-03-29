package com.example.mediumspringwebflux.domain.board.document;

import com.example.mediumspringwebflux.domain.comment.document.Comment;
import com.example.mediumspringwebflux.domain.user.document.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eclipse.collections.api.factory.Lists;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

import java.util.List;

@Getter
@Document
@NoArgsConstructor
public class Board {

    @Id
    private String id;

    private String title;

    private String description;

    private User writer;

    private List<Comment> comments = Lists.mutable.of();

    @Builder
    public Board(String title, String description, User writer, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.comments = comments;
    }

    //  I/O 작업이 없기 때문에 Mono를 반환할 필요가 없다고 판단
    public void edit(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Mono<Void> deleteComment(Comment comment) {
        return Mono.just(this.comments.remove(comment)).then();
    }

}
