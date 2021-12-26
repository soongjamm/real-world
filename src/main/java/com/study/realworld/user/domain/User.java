package com.study.realworld.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;

    @Builder
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
