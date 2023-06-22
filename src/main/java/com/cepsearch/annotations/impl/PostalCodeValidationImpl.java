package com.cepsearch.annotations.impl;

import com.cepsearch.annotations.PostalCodeValidation;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostalCodeValidationImpl implements ConstraintValidator<PostalCodeValidation, String> {

    @Override
    public void initialize(PostalCodeValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String postalCode, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(postalCode)) {
            return false;
        }
        return postalCode.matches("\\d{5}-\\d{3}|\\d{8}");
    }

}
