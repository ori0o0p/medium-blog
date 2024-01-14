package com.example.mediumspringwebfluxcorutine.board.document

import com.example.mediumspringwebfluxcorutine.board.dto.BoardRequest
import com.example.mediumspringwebfluxcorutine.board.dto.BoardResponse
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Board(
    @Id
    val id: ObjectId = ObjectId.get(),
    var title: String,
    var content: String,
    val createdDate: LocalDateTime,
    var updatedDate: LocalDateTime
) {

    fun toBoardResponse(): BoardResponse = BoardResponse(
        id = id.toString(),
        title = title,
        content = content
    )

    fun edit(boardRequest: BoardRequest) {
        title = boardRequest.title
        content = boardRequest.content
        updatedDate = LocalDateTime.now()
    }

}
