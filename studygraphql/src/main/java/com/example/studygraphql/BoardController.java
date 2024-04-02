package com.example.studygraphql;

import com.example.studygraphql.model.Board;
import com.example.studygraphql.service.CreateBoardService;
import com.example.studygraphql.service.FindBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final CreateBoardService createBoardService;
    private final FindBoardService findBoardService;

    @SchemaMapping(typeName = "Query", field = "findById")
    public Board findById(@Argument("id") Long id) {
        return findBoardService.findById(id);
    }

    @SchemaMapping(typeName = "Query", field = "findAll")
    public List<Board> findAll() {
        return findBoardService.findAll();
    }

    @SchemaMapping(typeName = "Mutation", field = "save")
    public void save(@Argument("title") String title, @Argument("content") String content) {
        createBoardService.create(title, content);
    }

}
