package com.study.realworld.user.adapter.in.web.dto;

import com.study.realworld.user.app.port.in.RegisterUserCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterUserDTO {
    private UserDTO user;

    @Getter
    @NoArgsConstructor
    public static class UserDTO {
        private String username;
        private String email;
        private String password;

        @Builder
        public UserDTO(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }
    }

    @Builder
    public RegisterUserDTO(UserDTO user) {
        this.user = user;
    }

    public RegisterUserCommand mapToCommand() {
        return RegisterUserCommand.builder()
                .username(this.user.username)
                .email(this.user.email)
                .password(this.user.password)
                .build();
    }

}
