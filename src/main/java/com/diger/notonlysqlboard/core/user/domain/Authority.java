package com.diger.notonlysqlboard.core.user.domain;

import lombok.Getter;

@Getter
public enum Authority {
    NOT_AVAILABLE, NORMAL, ADMIN;

    public void isUserCanWrite() {
        if (this.equals(NOT_AVAILABLE)) {
            throw new IllegalArgumentException("USER RESTRICTED");
        }
    }
}
