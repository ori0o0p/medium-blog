package com.example.studygraphql.service;

import com.example.studygraphql.model.Board;

import java.util.List;

public interface FindBoardService {
    List<Board> findAll();
    Board findById(Long id);

}
