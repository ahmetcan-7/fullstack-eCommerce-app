package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User user){
        return UserDto.builder()
                .displayName(user.getDisplayName())
                .username(user.getUsername())
                .build();
    }
}
