package com.example.studygraphql;

import com.example.studygraphql.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @SchemaMapping(typeName = "Query", field = "findById")
    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "findAll")
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @SchemaMapping(typeName = "Mutation", field = "save")
    public Board save(@Argument("title") String title, @Argument("content") String content) {
        return boardRepository.save(new Board(title, content));
    }

}
