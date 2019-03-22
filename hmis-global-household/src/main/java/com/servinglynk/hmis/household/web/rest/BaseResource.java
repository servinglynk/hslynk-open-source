package com.servinglynk.hmis.household.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.servinglynk.hmis.household.web.rest.util.Errors;
import com.servinglynk.hmis.household.web.rest.util.Error;
import com.servinglynk.hmis.household.web.rest.util.ExceptionMapper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;


public class BaseResource {

	
	@Autowired
	SessionHelper sessionHelper;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Errors processValidationError(MethodArgumentNotValidException ex,HttpServletRequest request,HttpServletResponse response) {
		Errors errors = new Errors();
		
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for(FieldError fieldError : fieldErrors){
        	Error error = new Error();
        	error.setMessage(fieldError.getDefaultMessage());
        	errors.addError(error);
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return errors;
    }
	
	
	@ExceptionHandler(Throwable.class)
	private Errors handleException(Throwable t, HttpServletRequest request, HttpServletResponse response)  {
	
		ExceptionMapper mapper = new ExceptionMapper();

		ExceptionMapper.Result result = mapper.map(t, request);
		Error er = new Error();
		
		er.setCode(result.getError().getCode());
		er.setMessage(result.getError().getMessage());
		
		
		Errors errors = new Errors();
		List<Error> errs = new ArrayList<Error>();
		errs.add(er);
		
		errors.setErrors(errs);
		
		response.setStatus(result.getStatusCode());
			
		return errors;
	}
	
}