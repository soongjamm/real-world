package com.study.realworld.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.study.realworld.Fixtures.aUser;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    @DisplayName("유저 정보를 변경한다.")
    void update_user() {
        User user = aUser().build();
        String email = "new_email@gmail.com";
        String bio = "new_bio";
        String image = "new_image";

        user.updateProfile(email, bio, image);

        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getBio()).isEqualTo(bio);
        assertThat(user.getImage()).isEqualTo(image);
    }
}
