package com.example.mediumspringwebflux.domain.board.service;

import com.example.mediumspringwebflux.domain.board.dto.BoardRequest;
import com.example.mediumspringwebflux.domain.board.document.Board;
import com.example.mediumspringwebflux.domain.board.repository.BoardRepository;
import com.example.mediumspringwebflux.domain.user.document.User;
import com.example.mediumspringwebflux.domain.user.service.UserFacade;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateBoard {
    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public CreateBoard(BoardRepository boardRepository, UserFacade userFacade) {
        this.boardRepository = boardRepository;
        this.userFacade = userFacade;
    }

    public Mono<Void> execute(BoardRequest request) {

        return userFacade.getUser()
                .map(user -> Board.builder()
                        .title(request.title())
                        .description(request.description())
                        .writer(user)
                        .build())
                .flatMap(boardRepository::save)
                .then();
    }

}
