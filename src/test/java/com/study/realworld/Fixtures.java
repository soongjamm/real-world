package com.study.realworld;

import com.study.realworld.user.adapter.out.persistence.UserJpaEntity;
import com.study.realworld.user.app.port.in.RegisterUserCommand;
import com.study.realworld.user.domain.User;

public class Fixtures {

    public static User.UserBuilder aUser() {
        return User.builder()
                .username("realworld")
                .password("realworld!")
                .email("realworld@email.com");
    }


    public static UserJpaEntity.UserJpaEntityBuilder aUserJpaEntity() {
        return UserJpaEntity.builder()
                .username("realworld")
                .password("realworld!")
                .email("realworld@email.com");
    }

    public static RegisterUserCommand.RegisterUserCommandBuilder aRegisterUserCommand() {
        return RegisterUserCommand.builder()
                .username("realworld")
                .password("realworld!")
                .email("realworld@email.com");
    }
}
