package com.servinglynk.hmis.warehouse.core.web.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;

public class EnrollmentSharingInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	protected BaseServiceFactory serviceFactory;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		
		System.out.println("Inside sharing interceptor ");
		
		System.out.println("Schema year is "+request.getContextPath().replaceAll("/hmis-clientapi-", ""));
		
		String schemaYear = request.getContextPath().replaceAll("/hmis-clientapi-", "");
		
		Boolean isClientSearch = request.getRequestURI().contains("/searchall/clients") ;
		
	
		List<UUID> enrollments  =	new ArrayList<>();
		List<UUID> clients		= new ArrayList<>();
		
		if(!isClientSearch) {
			enrollments = serviceFactory.getSharingRuleService().getSharedEnrollments(schemaYear);
			if(!enrollments.isEmpty()) clients = serviceFactory.getSharingRuleService().getSharedClients(enrollments, schemaYear);
		}else {
			enrollments = serviceFactory.getSharingRuleService().getSharedEnrollments(schemaYear);
			clients = serviceFactory.getSharingRuleService().getSharedClients(enrollments, schemaYear);	
		}
		System.out.println("Shared enrollments count "+enrollments.size()+" clients count "+clients.size());
		SecurityContext context =  SecurityContextHolder.getContext();
		LoggedInUser account = (LoggedInUser) context.getAuthentication().getPrincipal();
		LoggedInUser loggedInUser = new LoggedInUser(account.getUsername(),account.getProjectGroup(), enrollments, clients);
		Authentication authentication = new UsernamePasswordAuthenticationToken(loggedInUser,"");
		SecurityContextHolder.clearContext();
        SecurityContextHolder.getContext().setAuthentication(authentication);
		return true;
	}

}
