package com.diger.notonlysqlboard.core.user.service;

import com.diger.notonlysqlboard.core.user.domain.Authority;
import com.diger.notonlysqlboard.core.user.domain.LoginId;
import com.diger.notonlysqlboard.core.user.domain.Password;
import com.diger.notonlysqlboard.core.user.domain.User;
import com.diger.notonlysqlboard.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreator {

    private final UserRepository userRepository;

    public void execute(String loginId, String password) {
        userRepository.save(
                new User(
                        new LoginId(loginId),
                        new Password(password),
                        Authority.NOT_AVAILABLE
                )
        );
    }
}
