package com.example.mediumspringwebflux.domain.comment.controller;

import com.example.mediumspringwebflux.domain.comment.dto.CommentRequest;
import com.example.mediumspringwebflux.domain.comment.service.CreateComment;
import com.example.mediumspringwebflux.domain.comment.service.DeleteComment;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CreateComment createComment;
    private final DeleteComment deleteComment;

    public CommentController(CreateComment createComment, DeleteComment deleteComment) {
        this.createComment = createComment;
        this.deleteComment = deleteComment;
    }

    @PostMapping
    public Mono<Void> create(@RequestBody CommentRequest request) {
        return createComment.execute(request);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return deleteComment.execute(id);
    }

}
