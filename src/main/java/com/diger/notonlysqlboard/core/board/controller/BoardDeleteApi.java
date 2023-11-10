package com.diger.notonlysqlboard.core.board.controller;

import com.diger.notonlysqlboard.core.board.domain.Board;
import com.diger.notonlysqlboard.core.board.service.BoardDestroyer;
import com.diger.notonlysqlboard.util.aop.UserAuthentication;
import com.diger.notonlysqlboard.util.response.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardDeleteApi {

    private final BoardDestroyer boardDestroyer;

    @UserAuthentication
    @DeleteMapping("/{identifier}")
    public ResponseForm<List<Board>> execute(
            @PathVariable(value = "identifier") String identifier
    ) {
        boardDestroyer.execute(identifier);
        return ResponseForm.success(HttpStatus.OK);
    }
}
