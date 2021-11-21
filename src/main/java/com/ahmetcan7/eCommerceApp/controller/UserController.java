package com.ahmetcan7.eCommerceApp.controller;

import com.ahmetcan7.eCommerceApp.dto.CreateUserRequest;
import com.ahmetcan7.eCommerceApp.dto.UserDto;
import com.ahmetcan7.eCommerceApp.service.UserService;
import com.ahmetcan7.eCommerceApp.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public GenericResponse createUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        userService.createUser(createUserRequest);
        return new GenericResponse("user created");
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteProduct(@PathVariable("username") String username){
        userService.deleteUser(username);
        return ResponseEntity.ok().build();
    }

}
