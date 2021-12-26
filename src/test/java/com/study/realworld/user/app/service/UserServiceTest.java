package com.study.realworld.user.app.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("유저 생성")
    void create_user() {

    }

}
