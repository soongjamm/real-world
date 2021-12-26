package com.study.realworld.user.adapter.in.web.dto;

import com.study.realworld.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterUserResponseDTO {
    private UserDTO user;

    @Getter
    @NoArgsConstructor
    public static class UserDTO {
        private String email;
        private String token;
        private String username;
        private String bio;
        private String image;

        @Builder
        public UserDTO(String email, String token, String username, String bio, String image) {
            this.email = email;
            this.token = token;
            this.username = username;
            this.bio = bio;
            this.image = image;
        }
    }

    @Builder
    public RegisterUserResponseDTO(UserDTO user) {
        this.user = user;
    }

    public static RegisterUserResponseDTO from(User user) {
        UserDTO userDTO = UserDTO.builder()
                .email(user.getEmail())
                .username(user.getName())
                .build();

        return RegisterUserResponseDTO.builder()
                .user(userDTO)
                .build();
    }


}
