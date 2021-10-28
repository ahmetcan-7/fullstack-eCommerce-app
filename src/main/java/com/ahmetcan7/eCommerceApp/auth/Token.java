package com.ahmetcan7.eCommerceApp.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ahmetcan7.eCommerceApp.model.User;

import lombok.Data;

@Entity
@Data
public class Token {

    @Id
    private String token;

    @ManyToOne
    private User user;

}