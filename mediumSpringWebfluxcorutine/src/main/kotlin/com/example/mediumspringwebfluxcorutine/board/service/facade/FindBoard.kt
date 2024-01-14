package com.example.mediumspringwebfluxcorutine.board.service.facade

import com.example.mediumspringwebfluxcorutine.board.document.Board
import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component

@Component
class FindBoard(
    private val boardRepository: BoardRepository
) {

    suspend fun byId(id: String): Board = boardRepository.findById(id).awaitSingle()

}