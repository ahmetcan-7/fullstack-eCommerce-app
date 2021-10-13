package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User user){
        return UserDto.builder()
                .id(user.getId())
                .displayName(user.getDisplayName())
                .userName(user.getUserName())
                .password(user.getPassword())
                .build();
    }
}
