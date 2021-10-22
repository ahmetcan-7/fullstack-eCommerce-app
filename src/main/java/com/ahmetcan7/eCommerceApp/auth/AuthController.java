package com.ahmetcan7.eCommerceApp.auth;


import com.ahmetcan7.eCommerceApp.dto.UserDto;
import com.ahmetcan7.eCommerceApp.dto.UserDtoConverter;
import com.ahmetcan7.eCommerceApp.model.User;
import com.ahmetcan7.eCommerceApp.shared.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserDtoConverter userDtoConverter;

    @PostMapping
    ResponseEntity<UserDto> handleAuthentication(@CurrentUser User user) {

        return ResponseEntity.ok(userDtoConverter.convert(user));
    }


}
