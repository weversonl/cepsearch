package com.cepsearch.service.validators.impl;

import com.cepsearch.service.validators.ValidPostalCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidPostalCodeImpl implements ConstraintValidator<ValidPostalCode, String> {

    private static final int MAX_CEP_LENGTH = 8;

    @Override
    public void initialize(ValidPostalCode constraintAnnotation) {
	ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {

	if (Objects.isNull(cep) || cep.isEmpty()) {
	    return false;
	}

	if (cep.contains("-")) {
	    cep = cep.replace("-", "");
	} else if (!cep.matches("[0-9]+")) {
	    return false;
	}

	cep = cep.trim();

	return cep.length() <= MAX_CEP_LENGTH;

    }

}
