package com.study.realworld.user.app.service;

import com.study.realworld.common.UseCase;
import com.study.realworld.user.app.port.in.RegisterUserUseCase;
import com.study.realworld.user.app.port.in.RegisterUserCommand;
import com.study.realworld.user.app.port.out.RegisterUserPort;
import com.study.realworld.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UserService implements RegisterUserUseCase {

    private final RegisterUserPort registerUserPort;

    @Override
    public User register(RegisterUserCommand command) {
        User user = User.builder()
                .name(command.getName())
                .email(command.getEmail())
                .password(command.getPassword())
                .build();

        return registerUserPort.register(user);
    }
}
