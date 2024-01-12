package com.example.mediumspringwebflux.domain.comment.service;

import com.example.mediumspringwebflux.domain.board.repository.BoardRepository;
import com.example.mediumspringwebflux.domain.board.service.facade.FindBoard;
import com.example.mediumspringwebflux.domain.comment.document.Comment;
import com.example.mediumspringwebflux.domain.comment.dto.CommentRequest;
import com.example.mediumspringwebflux.domain.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateComment {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final FindBoard findBoard;

    public CreateComment(CommentRepository commentRepository, BoardRepository boardRepository, FindBoard findBoard) {
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
        this.findBoard = findBoard;
    }

    public Mono<Void> execute(CommentRequest request) {
        return findBoard.execute(request.boardId())
                .flatMap(board -> {
                    Comment comment = Comment.builder()
                            .comment(request.comment())
                            .boardId(board.getId())
                            .build();

                    return commentRepository.save(comment)
                            .then(Mono.just(board))
                            .flatMap(b -> {
                                b.getComments().add(comment);
                                return boardRepository.save(b);
                            });
                }).then();
    }

}
