package com.cepsearch.service.validators;

import com.cepsearch.service.validators.impl.ValidPostalCodeImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPostalCodeImpl.class)
@Documented
public @interface ValidPostalCode {

    String message() default "{checkcep.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}