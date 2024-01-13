package com.example.mediumspringwebfluxcorutine.board.service

import com.example.mediumspringwebfluxcorutine.board.dto.BoardResponse
import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class FindByIdBoard(
    private val boardRepository: BoardRepository
) {

    suspend fun execute(id: String): BoardResponse = boardRepository.findById(id)
        .awaitSingle().toBoardResponse()

}