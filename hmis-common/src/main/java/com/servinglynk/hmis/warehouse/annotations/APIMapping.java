package com.servinglynk.hmis.warehouse.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface APIMapping {
	String value() default "";
	boolean checkTrustedApp() default false;
	boolean checkSessionToken() default false;
}