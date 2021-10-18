package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.validator.UniqueUsername;
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
    @NotNull(message = "{eCommerceApp.constraint.username.NotNull.message}")
    @Size(min = 3,max = 25 ,message = "{eCommerceApp.constraint.username.Size.message}")
    @UniqueUsername(message = "{eCommerceApp.constraint.username.UniqueUsername.message}")
    private String username;

    @NotNull(message = "{eCommerceApp.constraint.username.NotNull.message}")
    @Size(min = 3,max = 25 ,message = "{eCommerceApp.constraint.username.Size.message}")
    private String displayName;

    @NotNull(message = "{eCommerceApp.constraint.username.NotNull.message}")
    @Size(min = 8, max=25,message = "{eCommerceApp.constraint.username.Size.message}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "{eCommerceApp.constrain.password.Pattern.message}")
    private String password;
}
