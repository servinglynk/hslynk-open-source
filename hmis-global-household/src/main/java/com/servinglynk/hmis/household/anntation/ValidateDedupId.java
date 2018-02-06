package com.servinglynk.hmis.household.anntation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.servinglynk.hmis.household.validator.ClientValidator;
import com.servinglynk.hmis.household.validator.DedupIdValidator;

@Retention(RUNTIME)
@Target({ FIELD,ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Documented
@Constraint(validatedBy=DedupIdValidator.class)
public @interface ValidateDedupId {

	 String message() default "Invalid Client Dedup Identification";
	 String clientIdField() default "";
	 String linkField() default "";
	 String dedupClientIdField() default "";
	 Class[] groups() default {};
	 Class[] payload() default {};
}