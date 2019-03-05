package com.servinglynk.hmis.warehouse.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.servinglynk.hmis.warehouse.validator.AllowedValuesValidator;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
@Constraint(validatedBy=AllowedValuesValidator.class)
public @interface AllowedValues {
	
	 String message() default "";
	 String[] values() default "";
	 Class[] groups() default {};
	 Class[] payload() default {};
}