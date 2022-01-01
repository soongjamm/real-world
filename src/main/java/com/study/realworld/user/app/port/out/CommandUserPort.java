package com.study.realworld.user.app.port.out;

import com.study.realworld.user.domain.User;

public interface CommandUserPort {

    User register(User user);
}
