package com.example.mediumspringwebfluxcorutine.board.controller

import com.example.mediumspringwebfluxcorutine.board.dto.BoardRequest
import com.example.mediumspringwebfluxcorutine.board.dto.BoardResponse
import com.example.mediumspringwebfluxcorutine.board.service.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val createBoard: CreateBoard,
    private val findAllBoard: FindAllBoard,
    private val findByIdBoard: FindByIdBoard,
    private val updateBoard: UpdateBoard,
    private val deleteBoard: DeleteBoard
) {

    @GetMapping
    suspend fun findAll(): List<BoardResponse> = findAllBoard.execute()

    @GetMapping("/{id}")
    suspend fun findById(@PathVariable id: String): BoardResponse = findByIdBoard.execute(id)

    @PostMapping
    suspend fun create(@RequestBody boardRequest: BoardRequest) = createBoard.execute(boardRequest)

    @PatchMapping("/{id}")
    suspend fun update(@PathVariable id: String, @RequestBody boardRequest: BoardRequest)
    = updateBoard.execute(id, boardRequest)

    @DeleteMapping("/{id}")
    suspend fun delete(@PathVariable id: String) = deleteBoard.execute(id)

}