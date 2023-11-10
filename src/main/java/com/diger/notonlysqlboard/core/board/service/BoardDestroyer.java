package com.diger.notonlysqlboard.core.board.service;

import com.diger.notonlysqlboard.core.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDestroyer {

    private final BoardRepository boardRepository;

    public void execute(String identifier) {
        boardRepository.delete(
                boardRepository.findById(identifier).get()
        );
    }
}
