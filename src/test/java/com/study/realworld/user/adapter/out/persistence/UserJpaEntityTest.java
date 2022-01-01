package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.Fixtures;
import com.study.realworld.user.adapter.out.persistence.UserJpaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserJpaEntityTest {

    @Test
    @DisplayName("유저 엔티티 생성")
    void create_user() {
        // given
        String name = "Jacob";
        String email = "jake@jake.jake";
        String password = "jakejake";

        // when
        UserJpaEntity user = Fixtures.aUserJpaEntity()
                .username(name)
                .email(email)
                .password(password)
                .build();

        // then
        assertThat(user.getUsername()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}
