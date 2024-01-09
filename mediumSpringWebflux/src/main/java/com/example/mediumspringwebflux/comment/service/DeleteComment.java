package com.example.mediumspringwebflux.comment.service;

import com.example.mediumspringwebflux.board.repository.BoardRepository;
import com.example.mediumspringwebflux.board.service.facade.FindBoard;
import com.example.mediumspringwebflux.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteComment {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final FindBoard findBoard;

    public DeleteComment(CommentRepository commentRepository, BoardRepository boardRepository, FindBoard findBoard) {
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
        this.findBoard = findBoard;
    }

    public Mono<Void> execute(String commentId) {
        return commentRepository.findById(commentId)
                .flatMap(comment ->
                        findBoard.execute(comment.getBoardId())
                                .flatMap(board -> board.deleteComment(comment)
                                        .then(boardRepository.save(board)))
                ).then(commentRepository.deleteById(commentId));
    }

}
