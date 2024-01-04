package com.example.mediumspringwebflux.board.service;

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
                .flatMap(board -> {
                    board.edit(request.title(), request.description());
                    return boardRepository.save(board);
                })).then();
    }

}
