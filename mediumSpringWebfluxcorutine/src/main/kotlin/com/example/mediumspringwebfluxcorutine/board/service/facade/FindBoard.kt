package com.example.mediumspringwebfluxcorutine.board.service.facade

import com.example.mediumspringwebfluxcorutine.board.document.Board
import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Component

@Component
class FindBoard(
    private val boardRepository: BoardRepository
) {

    suspend fun byId(id: String): Board {
        return boardRepository.findById(id).awaitSingleOrNull() ?: throw RuntimeException("게시물을 찾지 못함")
    }

}