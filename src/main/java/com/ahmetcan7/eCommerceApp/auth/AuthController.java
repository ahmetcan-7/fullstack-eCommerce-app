package com.ahmetcan7.eCommerceApp.auth;


import com.ahmetcan7.eCommerceApp.model.User;
import com.ahmetcan7.eCommerceApp.shared.CurrentUser;
import com.ahmetcan7.eCommerceApp.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser User user) {

        return ResponseEntity.ok(user);
    }


}
