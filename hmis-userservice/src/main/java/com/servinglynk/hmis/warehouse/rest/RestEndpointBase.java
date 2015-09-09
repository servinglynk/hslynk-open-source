package com.servinglynk.hmis.warehouse.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;
import com.servinglynk.hmis.warehouse.rest.common.ExceptionMapper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;


@Controller
public abstract class RestEndpointBase {

	/** Logger for this class and subclasses */

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected ParentServiceFactory serviceFactory;

	

	public ParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ParentServiceFactory serviceFactory) {
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

