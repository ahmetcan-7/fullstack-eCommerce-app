package com.ahmetcan7.eCommerceApp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    private String userName;
    private String displayName;
    private String password;
}
