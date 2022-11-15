package com.am.basketballshop.converters.user;

import com.am.basketballshop.api.dto.UserDto;
import com.am.basketballshop.model.security.User;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToEntity implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto source) {
        User user = new User();
        user.setId(source.getId());
        user.setLogin(source.getLogin());
        user.setPassword(source.getPassword());
        user.setEmail(source.getEmail());
        user.setName(source.getName());
        user.setAdmin(source.getAdmin());
        return user;
    }
}
