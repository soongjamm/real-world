package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.common.PersistenceAdapter;
import com.study.realworld.user.app.port.out.RegisterUserPort;
import com.study.realworld.user.domain.User;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements RegisterUserPort {

    private final SpringDataUserRepository springDataUserRepository;
    private final UserMapper userMapper;

    @Override
    public User register(User user) {
        UserJpaEntity userJpaEntity = userMapper.mapToJpaEntity(user);

        UserJpaEntity savedUserJapEntity = springDataUserRepository.save(userJpaEntity);

        return userMapper.mapToDomainEntity(savedUserJapEntity);
    }

}
