package com.study.realworld.user.adapter.in.web;

import com.study.realworld.user.adapter.in.web.dto.RegisterUserDTO;
import com.study.realworld.user.adapter.in.web.dto.RegisterUserResponseDTO;
import com.study.realworld.user.app.port.in.RegisterUserUseCase;
import com.study.realworld.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterUserController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/users")
    public RegisterUserResponseDTO register(@RequestBody RegisterUserDTO dto) {
        User user = registerUserUseCase.register(dto.mapToCommand());

        return RegisterUserResponseDTO.from(user);
    }


}
