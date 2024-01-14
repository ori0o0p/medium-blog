package com.example.mediumspringwebfluxcorutine.board.service

import com.example.mediumspringwebfluxcorutine.board.dto.BoardResponse
import com.example.mediumspringwebfluxcorutine.board.service.facade.FindBoard
import org.springframework.stereotype.Service

@Service
class FindByIdBoard(
    private val findBoard: FindBoard
) {

    suspend fun execute(id: String): BoardResponse = findBoard.byId(id).toBoardResponse()

}