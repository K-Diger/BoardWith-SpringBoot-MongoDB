package com.diger.notonlysqlboard.core.user.controller;

import com.diger.notonlysqlboard.core.user.controller.dto.UserRequestDto.UserJoinForm;
import com.diger.notonlysqlboard.core.user.service.UserCreator;
import com.diger.notonlysqlboard.util.response.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserJoinApi {

    private final UserCreator userCreator;

    @PostMapping
    public ResponseForm<Map<String, String>> execute(
            @RequestBody UserJoinForm userJoinForm
    ) {
        userCreator.execute(
                userJoinForm.getLoginId(),
                userJoinForm.getPassword()
        );

        return ResponseForm.success(
                HttpStatus.OK,
                new HashMap<>() {{
                    put("message", "SUCCESS!");
                }}
        );
    }
}
