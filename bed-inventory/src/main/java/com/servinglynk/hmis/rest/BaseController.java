package com.servinglynk.hmis.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.servinglynk.hmis.rest.common.ExceptionMapper;
import com.servinglynk.hmis.service.ServiceFactory;
import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.Errors;

public class BaseController {

	@Autowired protected ServiceFactory serviceFactory;
	
	
	@ExceptionHandler(Throwable.class)
	private Errors handleException(Throwable t, HttpServletRequest request, HttpServletResponse response) {
		
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
