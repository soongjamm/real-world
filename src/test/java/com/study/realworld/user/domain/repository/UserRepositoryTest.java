package com.study.realworld.user.domain.repository;

import com.study.realworld.Fixtures;
import com.study.realworld.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void persistence() {
        User user = Fixtures.aUser().build();
        assertThat(user.getId()).isNull();

        User result = userRepository.save(user);

        assertThat(result.getId()).isNotNull();
    }

}
