package com.example.mediumspringwebflux.comment.controller;

import com.example.mediumspringwebflux.comment.dto.CommentRequest;
import com.example.mediumspringwebflux.comment.service.CreateComment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CreateComment createComment;

    public CommentController(CreateComment createComment) {
        this.createComment = createComment;
    }

    @PostMapping
    public Mono<Void> create(@RequestBody CommentRequest request) {
        return createComment.execute(request);
    }

}
