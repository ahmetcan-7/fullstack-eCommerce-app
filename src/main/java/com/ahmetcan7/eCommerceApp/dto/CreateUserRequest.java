package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.validator.UniqueUserName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull
    @Size(min = 3,max = 25)
    @UniqueUserName
    private String userName;

    @NotNull
    @Size(min = 3,max = 25)
    private String displayName;

    @NotNull
    @Size(min = 8, max=25)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
