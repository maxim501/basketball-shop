package com.am.basketballshop.converters.user;

import com.am.basketballshop.api.dto.UserDto;
import com.am.basketballshop.model.security.User;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToDto  implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        return UserDto.builder()
                .id(source.getId())
                .login(source.getLogin())
                .password(source.getPassword())
                .email(source.getEmail())
                .name(source.getName())
                .admin(source.getAdmin())
                .build();
    }
}
