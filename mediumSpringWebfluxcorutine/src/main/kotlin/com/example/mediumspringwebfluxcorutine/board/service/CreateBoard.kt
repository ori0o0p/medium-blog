package com.example.mediumspringwebfluxcorutine.board.service

import com.example.mediumspringwebfluxcorutine.board.document.Board
import com.example.mediumspringwebfluxcorutine.board.dto.BoardRequest
import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class CreateBoard(
    private val boardRepository: BoardRepository
) {

    suspend fun execute(boardRequest: BoardRequest) {
        boardRepository.save(Board(
                title = boardRequest.title,
                content = boardRequest.content))
            .awaitSingle()
    }

}