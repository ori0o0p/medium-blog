package com.example.mediumspringwebflux.board.service;

import com.example.mediumspringwebflux.board.document.Board;
import com.example.mediumspringwebflux.board.dto.BoardRequest;
import com.example.mediumspringwebflux.board.repository.BoardRepository;
import com.example.mediumspringwebflux.board.service.Facade.FindBoard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateBoard {
    private final BoardRepository boardRepository;
    private final FindBoard findBoard;

    public UpdateBoard(BoardRepository boardRepository, FindBoard findBoard) {
        this.boardRepository = boardRepository;
        this.findBoard = findBoard;
    }

    public Mono<Void> execute(String id, BoardRequest request) {
        return Mono.defer(() -> findBoard.execute(id)
                .flatMap(board -> updateBoard(board, request)))
                .then();
    }

    private Mono<Board> updateBoard(Board board, BoardRequest request) {
        return Mono.fromRunnable(() -> {
            board.edit(request.title(), request.description());
        }).thenReturn(board);
    }

}
