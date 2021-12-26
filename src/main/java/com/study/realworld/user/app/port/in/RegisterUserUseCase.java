package com.study.realworld.user.app.port.in;

import com.study.realworld.user.domain.User;

public interface RegisterUserUseCase {

    User register(RegisterUserCommand command);
}
