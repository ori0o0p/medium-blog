package com.example.mediumspringwebfluxcorutine.board.service

import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class DeleteBoard(
    private val boardRepository: BoardRepository
) {

    suspend fun execute(id: String) {
        boardRepository.deleteById(id)
            .awaitSingleOrNull()
    }

}