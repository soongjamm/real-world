package com.study.realworld.user.app.port.in;

import com.study.realworld.user.domain.User;

public interface QueryUserUseCase {
    User getUser(GetUserQuery getUserQuery);
}
