package com.study.realworld.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String image;

    @Builder
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void updateProfile(String email, String bio, String image) {
        this.email = email;
        this.bio = bio;
        this.image = image;
    }
}
