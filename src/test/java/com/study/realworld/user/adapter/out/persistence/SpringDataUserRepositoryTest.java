package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.Fixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SpringDataUserRepositoryTest {

    @Autowired
    SpringDataUserRepository springDataUserRepository;

    @Test
    void persistence() {
        UserJpaEntity user = Fixtures.aUserJpaEntity().build();
        assertThat(user.getId()).isNull();

        UserJpaEntity result = springDataUserRepository.save(user);

        assertThat(result.getId()).isNotNull();
    }

}
