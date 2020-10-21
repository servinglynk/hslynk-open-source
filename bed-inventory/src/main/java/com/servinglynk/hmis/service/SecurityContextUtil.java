package com.servinglynk.hmis.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Session;

public class SecurityContextUtil {

	public static Account getUserAccount(){
			Session session = null;
			SecurityContext context =  SecurityContextHolder.getContext();
			Authentication authentication =  context.getAuthentication();
			if(authentication.getPrincipal()!=null){
				session = (Session) authentication.getPrincipal();
				return session.getAccount();
			}
			return null;
	}
	
	public static Session getSession(){
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		if(authentication.getPrincipal()!=null){
			return (Session) authentication.getPrincipal();
		}
		return null;
}
	
	
	public static String getUserProjectGroup(){
		Session session = null;
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		if(authentication.getPrincipal()!=null){
			session = (Session) authentication.getPrincipal();
			if(session.getAccount()!=null && session.getAccount().getProjectGroup()!=null)
				return session.getAccount().getProjectGroup().getProjectGroupCode();
		}
		return null;
	}
	
}