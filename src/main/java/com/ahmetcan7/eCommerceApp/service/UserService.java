package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.CreateUserRequest;
import com.ahmetcan7.eCommerceApp.dto.UserDto;
import com.ahmetcan7.eCommerceApp.dto.UserDtoConverter;
import com.ahmetcan7.eCommerceApp.model.User;
import com.ahmetcan7.eCommerceApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final PasswordEncoder passwordEncoder;

    public UserDto createUser(CreateUserRequest createUserRequest){
        final User user =User.builder()
                .userName(createUserRequest.getUserName())
                .displayName(createUserRequest.getDisplayName())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();

        return userDtoConverter.convert(userRepository.save(user));
    }

    public List<UserDto> getAllUsers(){
        List<User> userList= userRepository.findAll();
        return userList.stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }
}
