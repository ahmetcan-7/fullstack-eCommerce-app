package com.ahmetcan7.eCommerceApp.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String displayName;
    private String password;
}
