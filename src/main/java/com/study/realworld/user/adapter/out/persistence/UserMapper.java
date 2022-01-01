package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    User mapToDomainEntity(UserJpaEntity user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    UserJpaEntity mapToJpaEntity(User user) {
        return UserJpaEntity.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
