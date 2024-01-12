package com.example.mediumspringwebfluxcorutine.board.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Board(
    @Id
    val id: ObjectId = ObjectId.get(),
    val title: String,
    val content: String,
    val createdDate: LocalDateTime
)
