package com.example.mediumspringwebflux.board.controller;

import com.example.mediumspringwebflux.board.dto.BoardRequest;
import com.example.mediumspringwebflux.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.service.CreateBoard;
import com.example.mediumspringwebflux.board.service.FindAllBoard;
import com.example.mediumspringwebflux.board.service.FindByIdBoard;
import com.example.mediumspringwebflux.board.service.UpdateBoard;
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

    public BoardController(CreateBoard createBoard, FindAllBoard findAllBoard, FindByIdBoard findByIdBoard, UpdateBoard updateBoard) {
        this.createBoard = createBoard;
        this.findAllBoard = findAllBoard;
        this.findByIdBoard = findByIdBoard;
        this.updateBoard = updateBoard;
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

}
