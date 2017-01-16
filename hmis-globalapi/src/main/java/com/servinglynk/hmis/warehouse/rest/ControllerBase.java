package com.servinglynk.hmis.warehouse.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;
import com.servinglynk.hmis.warehouse.rest.common.ExceptionMapper;


@Controller
public abstract class ControllerBase {

	/** Logger for this class and subclasses */

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected BaseServiceFactory serviceFactory;

	

	public BaseServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(BaseServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	@Autowired
	public SessionHelper sessionHelper;
	
	@Autowired
	protected TrustedAppHelper trustedAppHelper;
	
	

	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	public void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

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

