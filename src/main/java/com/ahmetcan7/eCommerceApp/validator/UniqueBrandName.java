package com.ahmetcan7.eCommerceApp.validator;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueBrandNameValidator.class })
public @interface UniqueBrandName {

    String message() default "Brand name must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
