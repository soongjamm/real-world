package com.study.realworld.user.app.port.out;

import com.study.realworld.user.domain.User;

import java.util.Optional;

public interface QueryUserPort {

    Optional<User> findByEmail(String email);
}
