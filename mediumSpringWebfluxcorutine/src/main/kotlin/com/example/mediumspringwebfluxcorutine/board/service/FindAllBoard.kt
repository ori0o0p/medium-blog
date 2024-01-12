package com.example.mediumspringwebfluxcorutine.board.service

import com.example.mediumspringwebfluxcorutine.board.document.Board
import com.example.mediumspringwebfluxcorutine.board.dto.BoardResponse
import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Service

@Service
class FindAllBoard(
    private val boardRepository: BoardRepository
) {

    suspend fun execute(): List<BoardResponse> {
        val boards: List<Board> = boardRepository.findAll()
            .asFlow().toList()

        return boards.map { b -> wrap(b) }
    }

    private fun wrap(board: Board): BoardResponse {
        return BoardResponse(
            id = board.id.toString(),
            title = board.title,
            content = board.content
        )
    }

}