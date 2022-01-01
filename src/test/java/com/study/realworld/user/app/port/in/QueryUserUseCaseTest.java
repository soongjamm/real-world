package com.study.realworld.user.app.port.in;

import com.study.realworld.user.adapter.out.persistence.SpringDataUserRepository;
import com.study.realworld.user.adapter.out.persistence.UserJpaEntity;
import com.study.realworld.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.study.realworld.Fixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@Transactional
@SpringBootTest(webEnvironment = NONE)
class QueryUserUseCaseTest {

    @Autowired
    QueryUserUseCase queryUserUseCase;

    @Autowired
    SpringDataUserRepository springDataUserRepository;


    @Test
    @DisplayName("유저 정보 조회")
    void getUser() {
        // given
        UserJpaEntity savedUser = springDataUserRepository.save(aUserJpaEntity().build());
        GetUserQuery getUserQuery = aGetUserQuery().username(savedUser.getUsername()).build();

        // when
        User user = queryUserUseCase.getUser(getUserQuery);

        // then
        assertThat(user.getId()).isEqualTo(savedUser.getId());
    }
}
