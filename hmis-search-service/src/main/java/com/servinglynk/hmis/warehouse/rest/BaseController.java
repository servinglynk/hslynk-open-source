package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.Errors;

public class BaseController {
	
	
	
	@ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Errors processValidationError(HttpClientErrorException ex, HttpServletRequest request, HttpServletResponse response) {
		  response.setStatus(ex.getStatusCode().value());
		try {
			ObjectMapper mapper = JsonUtil.getObjectMapper();
				mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
			   mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
			return mapper.readValue(ex.getResponseBodyAsString(), Errors.class);
		} catch (Exception e) {
			e.printStackTrace();
			Errors errors = new Errors();
			Error error = new Error();
			error.setCode("UNKNOWN");
			error.setMessage("unexpected error occurred");
			errors.addError(error);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return errors;
		}
    }

}
