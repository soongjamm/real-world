package com.study.realworld.user.app.port.in;

import com.study.realworld.user.domain.User;

public interface CommandUserUseCase {

    User register(RegisterUserCommand command);

    User updateProfile(UpdateUserCommand command);
}
