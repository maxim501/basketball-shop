package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.UserDto;
import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.security.User;
import com.am.basketballshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UniversalConverter converter;

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        setUser(user, userDto);

        User saveUser = userRepository.save(user);
        return converter.entityToDto(saveUser, UserDto.class);
    }

    public UserDto getUser(String userId) {
        Optional<User> userById = userRepository.findById(userId);
        User user = userById.orElseThrow(() -> {
            throw new NotFoundException("Not found user by id = " + userId);
        });

        return converter.entityToDto(user, UserDto.class);
    }

    public UserDto updateUser(String userId, UserDto userDto) {
        Optional<User> userById = userRepository.findById(userId);
        User user = userById.orElseThrow(() -> {
            throw new NotFoundException("Not found user by id = " + userId);
        });
        setUser(user, userDto);

        User updateUser = userRepository.save(user);

        return converter.entityToDto(updateUser, UserDto.class);
    }

    public void deleteUser(String userId) {
        Optional<User> userById = userRepository.findById(userId);
        User user = userById.orElseThrow(() -> {
            throw new NotFoundException("Not found user by id = " + userId);
        });
        userRepository.delete(user);
    }

    public void setUser(User user, UserDto userDto) {
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setAdmin(userDto.getAdmin());
    }
}
