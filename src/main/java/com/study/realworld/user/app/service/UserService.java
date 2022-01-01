package com.study.realworld.user.app.service;

import com.study.realworld.common.UseCase;
import com.study.realworld.user.app.port.in.*;
import com.study.realworld.user.app.port.out.CommandUserPort;
import com.study.realworld.user.app.port.out.QueryUserPort;
import com.study.realworld.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UserService implements CommandUserUseCase, QueryUserUseCase {

    private final CommandUserPort commandUserPort;
    private final QueryUserPort queryUserPort;

    @Override
    public User register(RegisterUserCommand command) {
        User user = User.builder()
                .username(command.getUsername())
                .email(command.getEmail())
                .password(command.getPassword())
                .build();

        return commandUserPort.register(user);
    }

    @Override
    public User updateProfile(UpdateUserCommand command) {
        User user = queryUserPort.findByEmail(command.getEmail());

        user.updateProfile(command.getEmail(), command.getBio(), command.getImage());

        return user;
    }

    @Override
    public User getUser(GetUserQuery getUserQuery) {
        return queryUserPort.findByUsername(getUserQuery.getUsername()).orElseThrow(IllegalArgumentException::new);
    }
}
