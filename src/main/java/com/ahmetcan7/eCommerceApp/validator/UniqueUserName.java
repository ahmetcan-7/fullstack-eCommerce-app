package com.ahmetcan7.eCommerceApp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueUserNameValidator.class })
public @interface UniqueUserName{

    String message() default "User name must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
