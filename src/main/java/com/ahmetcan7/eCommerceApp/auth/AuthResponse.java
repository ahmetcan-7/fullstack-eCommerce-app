package com.ahmetcan7.eCommerceApp.auth;


import com.ahmetcan7.eCommerceApp.dto.UserDto;
import lombok.Data;

@Data
public class AuthResponse {

    private String token;

    private UserDto user;

}
