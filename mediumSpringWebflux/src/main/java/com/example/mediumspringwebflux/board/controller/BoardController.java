package com.example.mediumspringwebflux.board.controller;

import com.example.mediumspringwebflux.board.dto.BoardRequest;
import com.example.mediumspringwebflux.board.dto.BoardResponse;
import com.example.mediumspringwebflux.board.service.CreateBoard;
import com.example.mediumspringwebflux.board.service.FindAllBoard;
import com.example.mediumspringwebflux.board.service.FindByIdBoard;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final CreateBoard createBoard;
    private final FindAllBoard findAllBoard;
    private final FindByIdBoard findByIdBoard;

    public BoardController(CreateBoard createBoard, FindAllBoard findAllBoard, FindByIdBoard findByIdBoard) {
        this.createBoard = createBoard;
        this.findAllBoard = findAllBoard;
        this.findByIdBoard = findByIdBoard;
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

}
