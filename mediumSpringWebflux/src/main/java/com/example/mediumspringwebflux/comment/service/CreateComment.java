package com.example.mediumspringwebflux.comment.service;

import com.example.mediumspringwebflux.board.service.facade.FindBoard;
import com.example.mediumspringwebflux.comment.document.Comment;
import com.example.mediumspringwebflux.comment.dto.CommentRequest;
import com.example.mediumspringwebflux.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateComment {
    private final CommentRepository commentRepository;
    private final FindBoard findBoard;

    public CreateComment(CommentRepository commentRepository, FindBoard findBoard) {
        this.commentRepository = commentRepository;
        this.findBoard = findBoard;
    }

    public Mono<Void> execute(CommentRequest request) {
        return findBoard.execute(request.boardId())
                .map(board -> Comment.builder()
                        .comment(request.comment())
                        .board(board)
                        .build())
                .flatMap(commentRepository::save)
                .then();
    }

}
