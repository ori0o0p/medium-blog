package com.example.mediumspringwebfluxcorutine.board.repository

import com.example.mediumspringwebfluxcorutine.board.document.Board
import org.springframework.data.mongodb.repository.MongoRepository

interface BoardRepository: MongoRepository<Board, String> {
}