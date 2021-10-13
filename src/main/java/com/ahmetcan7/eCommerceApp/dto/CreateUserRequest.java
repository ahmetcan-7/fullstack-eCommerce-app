package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.validator.UniqueUserName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank
    @UniqueUserName
    private String userName;

    @NotBlank
    private String displayName;

    @NotBlank
    private String password;
}
