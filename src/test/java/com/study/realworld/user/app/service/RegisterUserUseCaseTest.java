package com.study.realworld.user.app.service;

import com.study.realworld.Fixtures;
import com.study.realworld.user.app.port.in.RegisterUserUseCase;
import com.study.realworld.user.app.port.in.RegisterUserCommand;
import com.study.realworld.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RegisterUserUseCaseTest {

    @Autowired
    RegisterUserUseCase registerUserUseCase;

    @Test
    @DisplayName("유저 생성")
    void create_user() {
        // given
        String email = "study_king@email.com";
        RegisterUserCommand user = Fixtures.aRegisterUserCommand()
                .email(email)
                .build();

        // when
        User registeredUser = registerUserUseCase.register(user);

        // then
        assertThat(registeredUser.getId()).isNotNull();
        assertThat(registeredUser.getEmail()).isEqualTo(email);
    }

}
