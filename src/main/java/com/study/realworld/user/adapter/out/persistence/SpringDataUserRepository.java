package com.study.realworld.user.adapter.out.persistence;

import com.study.realworld.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, Long> {
    Optional<User> findByEmail(String email);
}
