package com.study.realworld.user.domain;

import com.study.realworld.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    @DisplayName("유저 엔티티 생성")
    void create_user() {
        // given
        String name = "Jacob";
        String email = "jake@jake.jake";
        String password = "jakejake";

        // when
        User user = Fixtures.aUser()
                .name(name)
                .email(email)
                .password(password)
                .build();

        // then
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}
