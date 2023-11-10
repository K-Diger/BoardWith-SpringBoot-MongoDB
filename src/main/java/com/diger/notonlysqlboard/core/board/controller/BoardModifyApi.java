package com.diger.notonlysqlboard.core.board.controller;

import com.diger.notonlysqlboard.core.board.controller.dto.BoardRequestDto.BoardModifyForm;
import com.diger.notonlysqlboard.core.board.service.BoardModifier;
import com.diger.notonlysqlboard.util.response.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardModifyApi {

    private final BoardModifier boardModifier;

    @PutMapping("/{identifier}")
    public ResponseForm<Map<String, String>> execute(
            @PathVariable(value = "identifier") String identifier,
            @RequestBody BoardModifyForm boardModifyForm
    ) {

        boardModifier.execute(
                identifier,
                boardModifyForm.getTitle(),
                boardModifyForm.getTextContent(),
                boardModifyForm.getStaticContents()
        );
        return ResponseForm.success(HttpStatus.OK);
    }
}
