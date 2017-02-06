package com.servinglynk.hmis.warehouse.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.servinglynk.hmis.warehouse.annotations.AllowedValues;

public class AllowedValuesValidator implements ConstraintValidator<AllowedValues, String> {

	String[] values;
	String message;
	
	public void initialize(AllowedValues arg0) {
			values = arg0.values();
			message = arg0.message();
		
	}

	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		if(!Arrays.asList(values).contains(arg0)){
				arg1.disableDefaultConstraintViolation();
				arg1.buildConstraintViolationWithTemplate(message).addConstraintViolation();
				return false;
		}
		return true;
	}


}