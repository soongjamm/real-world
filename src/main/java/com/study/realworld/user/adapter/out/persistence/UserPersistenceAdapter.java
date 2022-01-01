package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.common.PersistenceAdapter;
import com.study.realworld.user.app.port.out.CommandUserPort;
import com.study.realworld.user.app.port.out.QueryUserPort;
import com.study.realworld.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements CommandUserPort, QueryUserPort {

    private final SpringDataUserRepository springDataUserRepository;
    private final UserMapper userMapper;

    @Override
    public User register(User user) {
        UserJpaEntity userJpaEntity = userMapper.mapToJpaEntity(user);

        UserJpaEntity savedUserJapEntity = springDataUserRepository.save(userJpaEntity);

        return userMapper.mapToDomainEntity(savedUserJapEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email);
    }
}
