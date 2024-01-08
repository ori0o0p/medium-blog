package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.repository.BoardRepository;
import com.example.mediumspringwebflux.board.service.facade.FindBoard;
import com.example.mediumspringwebflux.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteBoard {
    private final BoardRepository boardRepository;
    private final FindBoard findBoard;
    private final CommentRepository commentRepository;

    public DeleteBoard(BoardRepository boardRepository, FindBoard findBoard, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.findBoard = findBoard;
        this.commentRepository = commentRepository;
    }

    public Mono<Void> execute(String id) {
        return findBoard.execute(id)
                .flatMap(board -> boardRepository.delete(board)
                        .then(commentRepository.deleteAll(board.getComments())));
    }

}
