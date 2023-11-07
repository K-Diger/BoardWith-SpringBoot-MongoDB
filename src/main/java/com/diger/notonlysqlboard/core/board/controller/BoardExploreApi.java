package com.diger.notonlysqlboard.core.board.controller;

import com.diger.notonlysqlboard.core.board.domain.Board;
import com.diger.notonlysqlboard.core.board.service.BoardExplorer;
import com.diger.notonlysqlboard.util.response.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardExploreApi {

    private final BoardExplorer boardExplorer;

    @GetMapping
    public ResponseForm<List<Board>> execute(
            @RequestParam(value = "page", defaultValue = "-1") Integer page,
            @RequestParam(value = "size", defaultValue = "-1") Integer size
    ) {
        return ResponseForm.success(
                HttpStatus.OK,
                boardExplorer.execute(page, size)
        );
    }
}
