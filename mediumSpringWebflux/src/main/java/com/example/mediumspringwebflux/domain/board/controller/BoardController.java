package com.example.mediumspringwebflux.domain.board.controller;

import com.example.mediumspringwebflux.domain.board.dto.BoardRequest;
import com.example.mediumspringwebflux.domain.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.service.*;
import com.example.mediumspringwebflux.domain.board.service.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final CreateBoard createBoard;
    private final FindAllBoard findAllBoard;
    private final FindByIdBoard findByIdBoard;
    private final UpdateBoard updateBoard;
    private final DeleteBoard deleteBoard;

    public BoardController(CreateBoard createBoard, FindAllBoard findAllBoard, FindByIdBoard findByIdBoard, UpdateBoard updateBoard, DeleteBoard deleteBoard) {
        this.createBoard = createBoard;
        this.findAllBoard = findAllBoard;
        this.findByIdBoard = findByIdBoard;
        this.updateBoard = updateBoard;
        this.deleteBoard = deleteBoard;
    }

    @PostMapping
    public Mono<Void> create(@RequestBody BoardRequest request) {
        return createBoard.execute(request);
    }

    @GetMapping
    public Flux<BoardResponse> findAll() {
        return findAllBoard.execute();
    }

    @GetMapping("/{id}")
    public Mono<BoardResponse> findById(@PathVariable String id) {
        return findByIdBoard.execute(id);
    }

    @PutMapping("/{id}")
    public Mono<Void> update(@RequestBody BoardRequest request, @PathVariable String id) {
        return updateBoard.execute(id, request);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return deleteBoard.execute(id);
    }

}
