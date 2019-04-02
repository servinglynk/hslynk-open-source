package com.servinglynk.hmis.warehouse.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditUtil {
	
	public static String getLoginUser() {
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		
		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			return entity.getUsername();
			}else {
				return null;
			}
	}

	
	public static String getLoginUserProjectGroup() {
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		
		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			return entity.getProjectGroup();
			}else {
				return null;
			}
	}
}
