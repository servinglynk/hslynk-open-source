package com.servinglynk.hmis.warehouse.base.service.impl;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Parameter;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.collections15.map.HashedMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.base.service.SubscriptionEventService;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.EnrollmentSharingModel;


public class SubscriptionEventServiceImpl implements SubscriptionEventService {

	@Autowired SessionHelper sessionHelper;
	
	@Autowired JmsTemplate jmsMessagingTemplate;

	@Transactional
	@Async
	public void publishEvent(ContentCachingRequestWrapper requestWrapper, ContentCachingResponseWrapper responseWrapper,
			Object handler) {
		Session session = sessionHelper.getSession(requestWrapper);
			AMQEvent amqEvent =new AMQEvent();
			Map<String, Object> payload = new HashedMap<String, Object>();
			payload.put("requestBody",getRequestBody(requestWrapper));
			payload.put("projectGroupCode",session.getAccount().getProjectGroup().getProjectGroupCode());
			payload.put("requestUrl", requestWrapper.getRequestURI());
			amqEvent.setPayload(payload);
			amqEvent.setCreatedAt(new Date());
			amqEvent.setEventType("subscription-event");
			amqEvent.setSubsystem("hmis-clientapi");
			
			ActiveMQQueue queue = new ActiveMQQueue("subscription.event");
			try {
				jmsMessagingTemplate.convertAndSend(queue,JsonUtil.coneveterObejctToString(amqEvent.toJSONString()));
			} catch (JmsException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	  public static String getRequestBody(ContentCachingRequestWrapper req) {
		    String body = null;
		    if (req.getContentLength() > 0) {
		    	System.out.println(req.getContentAsByteArray().toString());
		      body = new String(req.getContentAsByteArray());
		    }
		    return body.replaceAll("(\\r|\\n)", "");
		  }



	@Transactional
	@Async
	public void publishEvent(JoinPoint jp, Authentication authentication) {
	    AMQEvent request = new AMQEvent();
	 
	    Map<String, Object> payload = new HashMap<String, Object>();
	    Map<String, Object> user = new HashMap<String, Object>();
		Map<String, Object> requestparams = new HashMap<String, Object>();
		Object reqestBody = null;
		Map<String,Object> requestHeaders = new HashMap<String, Object>();
		Map<String,Object> pathParams = new HashMap<String, Object>();
		
		  MethodSignature methodSignature = (MethodSignature) jp.getStaticPart().getSignature();
		  java.lang.reflect.Method method = methodSignature.getMethod();
			 APIMapping apiMapping = method.getDeclaredAnnotation(APIMapping.class);
			   request.setEventType(apiMapping.value());
		    Parameter[] parameters = method.getParameters();
		    int i=0;

		    if(apiMapping!= null ) {
				    for (Parameter parameter : parameters) {
				    	Annotation annotation  = null;
				        annotation = parameter.getAnnotation(RequestBody.class);
				        if (annotation != null) {
				        		Object arg = jp.getArgs()[i];
				        		reqestBody = arg;			        		
				        }
				        annotation = parameter.getAnnotation(PathVariable.class);
				        if (annotation != null) {
			        		Object arg = jp.getArgs()[i];
			        		pathParams.put(parameter.getName(), arg);		        		
				        }
				        annotation = parameter.getAnnotation(RequestParam.class);
				        if (annotation != null) {
			        		Object arg = jp.getArgs()[i];
			        		requestparams.put(parameter.getName(), arg);		        		
				        }
				        i++;
				    }
		    }
		    
		    
				if(authentication != null && authentication.getPrincipal()!=null){
					LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
					  payload.put("projectGroupCode", entity.getProjectGroup());
					  payload.put("requestUrl", entity.getUrl());
				}

		    payload.put("user", user);
		    payload.put("reqestBody", reqestBody);
		    payload.put("requestparams", requestparams);
		    payload.put("pathParams", pathParams);  
		    payload.put("requestHeaders", requestHeaders); 
		  
		    request.setPayload(payload);
		    request.setCreatedAt(new Date());
		    request.setEventType("subscription-event");
		    request.setSubsystem("hmis-clientapi");
			
			ActiveMQQueue queue = new ActiveMQQueue("subscription.event");
			try {
				jmsMessagingTemplate.convertAndSend(queue,request.toJSONString());
			} catch (JmsException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	

}
