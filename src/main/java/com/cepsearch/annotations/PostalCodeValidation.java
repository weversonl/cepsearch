package com.cepsearch.annotations;

import com.cepsearch.annotations.impl.PostalCodeValidationImpl;
import com.cepsearch.util.message.ValidationMessages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PostalCodeValidationImpl.class)
@Documented
public @interface PostalCodeValidation {

    String message() default ValidationMessages.INVALID_POSTAL_CODE;

    String example() default ValidationMessages.VALID_POSTAL_CODE_EXAMPLE;

    String description() default ValidationMessages.INVALID_POSTAL_CODE_DESCRIPTION;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}