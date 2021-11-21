package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.CreateUserRequest;
import com.ahmetcan7.eCommerceApp.dto.UserDto;
import com.ahmetcan7.eCommerceApp.dto.UserDtoConverter;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Product;
import com.ahmetcan7.eCommerceApp.model.User;
import com.ahmetcan7.eCommerceApp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(CreateUserRequest createUserRequest){
        final User user =User.builder()
                .username(createUserRequest.getUsername())
                .displayName(createUserRequest.getDisplayName())
                .password(this.passwordEncoder.encode(createUserRequest.getPassword()))
                .build();

        userRepository.save(user);

    }

    public List<UserDto> getAllUsers(){
        List<User> userList= userRepository.findAll();
        return userList.stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public void deleteUser(String username){
        final User user=userRepository.findByUsername(username);

        userRepository.deleteById(user.getId());
    }
}
