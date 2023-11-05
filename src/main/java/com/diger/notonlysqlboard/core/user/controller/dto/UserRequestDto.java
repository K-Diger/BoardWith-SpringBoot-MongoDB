package com.diger.notonlysqlboard.core.user.controller.dto;

import lombok.Getter;

public class UserRequestDto {

    @Getter
    public static class UserJoinForm {
        String loginId;
        String password;
    }

}
