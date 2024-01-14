package com.example.mediumspringwebfluxcorutine.board.service

import com.example.mediumspringwebfluxcorutine.board.document.Board
import com.example.mediumspringwebfluxcorutine.board.dto.BoardRequest
import com.example.mediumspringwebfluxcorutine.board.repository.BoardRepository
import com.example.mediumspringwebfluxcorutine.board.service.facade.FindBoard
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class UpdateBoard(
    private val boardRepository: BoardRepository,
    private val findBoard: FindBoard
) {

    suspend fun execute(id: String,
                        boardRequest: BoardRequest) {
        val board: Board = findBoard.byId(id)

        board.edit(boardRequest)

        boardRepository.save(board)
            .awaitSingle()
    }

}