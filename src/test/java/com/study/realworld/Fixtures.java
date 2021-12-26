package com.study.realworld;

import com.study.realworld.user.domain.User;

public class Fixtures {

    public static User.UserBuilder aUser() {
        return User.builder()
                .name("jake")
                .password("Jakejake!")
                .email("jake@jake.jake");
    }

}
