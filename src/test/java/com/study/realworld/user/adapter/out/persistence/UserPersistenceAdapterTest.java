package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.Fixtures;
import com.study.realworld.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({UserPersistenceAdapter.class, UserMapper.class})
class UserPersistenceAdapterTest {

    @Autowired
    UserPersistenceAdapter userPersistenceAdapter;

    @Test
    @DisplayName("유저 생성")
    void createUser() {
        // given
        User user = Fixtures.aUser().build();
        assertThat(user.getId()).isNull();

        // when
        User savedUser = userPersistenceAdapter.register(user);

        // then
        assertThat(savedUser.getId()).isNotNull();
    }



}
