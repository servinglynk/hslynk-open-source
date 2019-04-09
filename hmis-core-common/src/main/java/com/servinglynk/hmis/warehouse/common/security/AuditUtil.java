package com.servinglynk.hmis.warehouse.common.security;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	
	public static UUID getLoginUserId() {
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		
		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			return entity.getUserId();
			}else {
				return null;
			}
	}
	
	public static List<UUID> getSharedClients() {
		List<UUID> clients = new ArrayList<UUID>();
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		
		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			return entity.getClients();
			}else {
				return clients;
			}
	}
	
	public static List<UUID> getSharedEnrollments() {
		List<UUID> enrollments = new ArrayList<UUID>();
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		
		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			return entity.getEnrollments();
			}else {
				return enrollments;
			}
	}
}
