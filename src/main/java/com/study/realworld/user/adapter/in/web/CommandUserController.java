package com.study.realworld.user.adapter.in.web;

import com.study.realworld.user.adapter.in.web.dto.RegisterUserDTO;
import com.study.realworld.user.adapter.in.web.dto.RegisterUserResponseDTO;
import com.study.realworld.user.app.port.in.CommandUserUseCase;
import com.study.realworld.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommandUserController {

    private final CommandUserUseCase commandUserUseCase;

    @PostMapping("/users")
    public RegisterUserResponseDTO register(@RequestBody RegisterUserDTO dto) {
        User user = commandUserUseCase.register(dto.mapToCommand());

        return RegisterUserResponseDTO.from(user);
    }


}
