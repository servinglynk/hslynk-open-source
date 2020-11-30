package com.servinglynk.hmis.warehouse.base.service.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.servinglynk.hmis.warehouse.annotations.Subscription;
import com.servinglynk.hmis.warehouse.base.service.SubscriptionEventService;

@Aspect
public class SubscriptionInterceptor { //extends HandlerInterceptorAdapter  {

	@Autowired SubscriptionEventService subscriptionEventService;
    
	@Before("@annotation(com.servinglynk.hmis.warehouse.annotations.Subscription)")
	public void before(JoinPoint jp){
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		subscriptionEventService.publishEvent(jp,authentication);
	}
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("request method"+request.getMethod());
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        System.out.println("Request body is "+getRequestBody(requestWrapper));
        
		subscriptionEventService.publishEvent(requestWrapper, responseWrapper, handler);
		return true;
	}
	
	public static String getRequestBody(ContentCachingRequestWrapper req) {
	    String body = null;
	    if (req.getContentLength() > 0) {
	    	System.out.println(req.getContentAsByteArray().toString());
	      body = new String(req.getContentAsByteArray());
	    }
	    return body.replaceAll("(\\r|\\n)", "");
	  }
	
	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}
}
