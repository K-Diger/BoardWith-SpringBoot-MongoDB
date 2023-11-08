package com.diger.notonlysqlboard.util.aop;

import com.diger.notonlysqlboard.core.user.domain.User;

public class UserAuthenticationContext {

    static final ThreadLocal<User> USER_CONTEXT = new ThreadLocal<>();

    public static User getUser() {
        return USER_CONTEXT.get();
    }
}
