package com.diger.notonlysqlboard.core.user.controller;

import com.diger.notonlysqlboard.core.user.controller.dto.UserRequestDto.UserJoinForm;
import com.diger.notonlysqlboard.core.user.domain.LoginId;
import com.diger.notonlysqlboard.core.user.domain.Password;
import com.diger.notonlysqlboard.core.user.service.UserAuthenticator;
import com.diger.notonlysqlboard.util.response.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserAuthenticateApi {

    private final UserAuthenticator userAuthenticator;

    @PutMapping("/authority")
    public ResponseForm<Map<String, String>> execute(
            @RequestBody UserJoinForm userJoinForm
    ) {
        userAuthenticator.execute(
                new LoginId(userJoinForm.getLoginId()),
                new Password(userJoinForm.getPassword())
        );

        return ResponseForm.success(
                HttpStatus.OK,
                new HashMap<>() {{
                    put("message", "SUCCESS!");
                }}
        );
    }
}
