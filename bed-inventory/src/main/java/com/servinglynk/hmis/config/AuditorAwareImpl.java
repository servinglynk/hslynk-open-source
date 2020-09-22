package com.servinglynk.hmis.config;

import java.util.UUID;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.core.model.Session;

public class AuditorAwareImpl implements AuditorAware<UUID> {


	@Override
	public UUID getCurrentAuditor() {
		Session session = null;
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		if(authentication.getPrincipal()!=null){
			session = (Session) authentication.getPrincipal();
			return session.getAccount().getAccountId();
		}
		return null;
	}
}
