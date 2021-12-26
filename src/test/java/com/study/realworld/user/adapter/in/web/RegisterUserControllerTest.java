package com.study.realworld.user.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.realworld.Fixtures;
import com.study.realworld.user.adapter.in.web.dto.RegisterUserDTO;
import com.study.realworld.user.app.port.in.RegisterUserCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterUserControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("유저 생성")
    void register() throws Exception {
        // given
        String username = "new_realworld";
        String email = "new_realworld1@email.com";
        RegisterUserDTO.UserDTO userDto = RegisterUserDTO.UserDTO.builder()
                .username(username)
                .email(email)
                .password("12345678")
                .build();

        RegisterUserDTO dto = RegisterUserDTO.builder().user(userDto).build();


        String jsonCommand = objectMapper.writeValueAsString(dto);

        // when
        ResultActions perform = mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(jsonCommand));

        // then
        perform.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.email").value(email));
    }

}
