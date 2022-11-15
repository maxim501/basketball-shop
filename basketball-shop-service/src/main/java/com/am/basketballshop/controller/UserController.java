package com.am.basketballshop.controller;

import com.am.basketballshop.api.UserEndpoint;
import com.am.basketballshop.api.dto.UserDto;
import com.am.basketballshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController implements UserEndpoint {
    private final UserService userService;

    @Override
    public UserDto createUser(UserDto clientDto) {
        return userService.createUser(clientDto);
    }

    @Override
    public UserDto getUser(String clientId) {
        return userService.getUser(clientId);
    }

    @Override
    public UserDto updateUser(String clientId, UserDto clientDto) {
        return userService.updateUser(clientId, clientDto);
    }

    @Override
    public void deleteUser(String clientId) {
        userService.deleteUser(clientId);
    }
}
