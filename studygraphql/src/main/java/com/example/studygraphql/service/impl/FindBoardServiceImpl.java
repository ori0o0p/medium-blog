package com.example.studygraphql.service.impl;

import com.example.studygraphql.BoardRepository;
import com.example.studygraphql.model.Board;
import com.example.studygraphql.service.FindBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindBoardServiceImpl implements FindBoardService {
    private final BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElse(null);
    }

}
