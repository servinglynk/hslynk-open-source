package com.servinglynk.hmis.warehouse.base.service;

import org.aspectj.lang.JoinPoint;
import org.springframework.security.core.Authentication;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

public interface SubscriptionEventService {

	public void publishEvent(ContentCachingRequestWrapper requestWrapper,
			ContentCachingResponseWrapper responseWrapper,Object handler);
	
	public void publishEvent(JoinPoint jp, Authentication authentication);
}