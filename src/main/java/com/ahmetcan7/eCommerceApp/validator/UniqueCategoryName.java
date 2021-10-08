package com.ahmetcan7.eCommerceApp.validator;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueCategoryNameValidator.class })
public @interface UniqueCategoryName {
    String message() default "Category name must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
