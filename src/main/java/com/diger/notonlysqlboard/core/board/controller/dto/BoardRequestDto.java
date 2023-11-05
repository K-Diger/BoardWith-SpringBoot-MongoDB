package com.diger.notonlysqlboard.core.board.controller.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

public class BoardRequestDto {

    @Getter
    public static class BoardCreateForm {
        String title;
        String textContent;
        MultipartFile[] staticContents;
    }
}
