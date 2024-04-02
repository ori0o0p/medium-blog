package com.example.studygraphql.service.impl;

import com.example.studygraphql.BoardRepository;
import com.example.studygraphql.model.Board;
import com.example.studygraphql.service.CreateBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBoardServiceImpl implements CreateBoardService {
    private final BoardRepository boardRepository;

    @Override
    public void create(String title, String content) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        boardRepository.save(board);
    }
    
}
