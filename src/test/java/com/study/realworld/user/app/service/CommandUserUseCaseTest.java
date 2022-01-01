package com.study.realworld.user.app.service;

import com.study.realworld.Fixtures;
import com.study.realworld.user.adapter.out.persistence.SpringDataUserRepository;
import com.study.realworld.user.adapter.out.persistence.UserJpaEntity;
import com.study.realworld.user.app.port.in.CommandUserUseCase;
import com.study.realworld.user.app.port.in.RegisterUserCommand;
import com.study.realworld.user.app.port.in.UpdateUserCommand;
import com.study.realworld.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.study.realworld.Fixtures.aUserJpaEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class CommandUserUseCaseTest {

    @Autowired
    CommandUserUseCase commandUserUseCase;

    @Autowired
    SpringDataUserRepository springDataUserRepository;

    @Test
    @DisplayName("유저 생성")
    void create_user() {
        // given
        String email = "study_king@email.com";
        RegisterUserCommand user = Fixtures.aRegisterUserCommand()
                .email(email)
                .build();

        // when
        User registeredUser = commandUserUseCase.register(user);

        // then
        assertThat(registeredUser.getId()).isNotNull();

        assertThat(registeredUser.getEmail()).isEqualTo(email);
    }

    @Test
    @DisplayName("유저 정보를 변경한다.")
    void update_user() {
        UserJpaEntity user = springDataUserRepository.save(aUserJpaEntity().build());
        UpdateUserCommand command = Fixtures.aUpdateUserCommand().email(user.getEmail()).build();

        User updatedUser = commandUserUseCase.updateProfile(command);

        assertThat(updatedUser.getEmail()).isEqualTo(command.getEmail());
        assertThat(updatedUser.getBio()).isEqualTo(command.getBio());
        assertThat(updatedUser.getImage()).isEqualTo(command.getImage());
    }
}
