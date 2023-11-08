package com.diger.notonlysqlboard.core.user.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("passowrd")
public class Password {

    private final String password;

    public Password(String password) {
        validateField(password);
        this.password = encryptPassword(password);
    }

    private void validateField(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password Must Not be Null");
        }

        if (password.length() > 20) {
            throw new IllegalArgumentException("Password's length Must Be Lower Than 20");
        }

        if (password.length() < 5) {
            throw new IllegalArgumentException("LoginId's length Must Be Bigger Than 5");
        }
    }

    private String encryptPassword(String password) {
        return password;
    }
}
