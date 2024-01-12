package com.example.mediumspringwebfluxcorutine.board.controller

import com.example.mediumspringwebfluxcorutine.board.dto.BoardRequest
import com.example.mediumspringwebfluxcorutine.board.dto.BoardResponse
import com.example.mediumspringwebfluxcorutine.board.service.CreateBoard
import com.example.mediumspringwebfluxcorutine.board.service.FindAllBoard
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val createBoard: CreateBoard,
    private val findAllBoard: FindAllBoard
) {

    @GetMapping
    suspend fun findAll(): List<BoardResponse> {
        return findAllBoard.execute()
    }

    @PostMapping
    suspend fun create(@RequestBody boardRequest: BoardRequest) {
        createBoard.execute(boardRequest)
    }

}