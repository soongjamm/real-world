package com.study.realworld.user.domain.repository;

import com.study.realworld.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
