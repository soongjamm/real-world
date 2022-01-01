package com.study.realworld.user.app.port.in;

import com.study.realworld.common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterUserCommand extends SelfValidating {
    @NotNull
    private final String username;

    @NotNull
    private final String email;

    @NotNull
    private final String password;

    @Builder
    public RegisterUserCommand(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
