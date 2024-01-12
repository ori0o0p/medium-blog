package com.example.mediumspringwebfluxcorutine.board.controller

import com.example.mediumspringwebfluxcorutine.board.dto.BoardRequest
import com.example.mediumspringwebfluxcorutine.board.service.CreateBoard
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val createBoard: CreateBoard
) {


    @PostMapping
    suspend fun create(@RequestBody boardRequest: BoardRequest) {
        createBoard.execute(boardRequest)
    }

}