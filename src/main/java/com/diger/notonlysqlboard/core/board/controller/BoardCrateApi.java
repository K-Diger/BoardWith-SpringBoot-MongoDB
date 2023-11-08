package com.diger.notonlysqlboard.core.board.controller;

import com.diger.notonlysqlboard.core.board.controller.dto.BoardRequestDto.BoardCreateForm;
import com.diger.notonlysqlboard.core.board.service.BoardCreator;
import com.diger.notonlysqlboard.util.aop.UserAuthenticationContext;
import com.diger.notonlysqlboard.util.aop.UserAuthentication;
import com.diger.notonlysqlboard.util.response.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardCrateApi {

    private final BoardCreator boardCreator;

    @PostMapping
    @UserAuthentication
    public ResponseForm execute(
            @RequestBody BoardCreateForm boardCreateForm
    ) {

        boardCreator.execute(
                boardCreateForm.getTitle(),
                boardCreateForm.getTextContent(),
                boardCreateForm.getStaticContents(),
                UserAuthenticationContext.getUser()
        );

        return ResponseForm.success(HttpStatus.OK);
    }
}
