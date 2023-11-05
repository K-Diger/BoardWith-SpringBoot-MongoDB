package com.diger.notonlysqlboard.core.user.domain;

import lombok.Getter;

@Getter
public class LoginId {

    private final String value;

    public LoginId(String value) {
        validateField(value);
        this.value = value;
    }

    private void validateField(String loginId) {
        if (loginId == null) {
            throw new IllegalArgumentException("LoginId Must Not be Null");
        }

        if (loginId.length() > 20) {
            throw new IllegalArgumentException("LoginId's length Must Be Lower Than 20");
        }

        if (loginId.length() < 5) {
            throw new IllegalArgumentException("LoginId's length Must Be Bigger Than 5");
        }
    }
}
