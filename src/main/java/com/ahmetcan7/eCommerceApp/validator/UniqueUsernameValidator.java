package com.ahmetcan7.eCommerceApp.validator;

import com.ahmetcan7.eCommerceApp.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return !userRepository.existsByUsername(userName);
    }
}
