package com.diger.notonlysqlboard.core.user.service;

import com.diger.notonlysqlboard.core.user.domain.Authority;
import com.diger.notonlysqlboard.core.user.domain.LoginId;
import com.diger.notonlysqlboard.core.user.domain.Password;
import com.diger.notonlysqlboard.core.user.domain.User;
import com.diger.notonlysqlboard.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAuthenticator {

    private final UserRepository userRepository;

    public void execute(LoginId loginId, Password password) {
        User user = userRepository.findByLoginIdAndPassword(
                loginId,
                password
        );

        user.updateAuthority(Authority.NORMAL);
        userRepository.save(user);
    }
}
