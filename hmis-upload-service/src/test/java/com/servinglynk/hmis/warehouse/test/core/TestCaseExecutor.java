package com.servinglynk.hmis.warehouse.test.core;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.tags.Param;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;

public class TestCaseExecutor {
	
	

	@Autowired WebApplicationContext wac;
	@Autowired MockHttpServletRequest request;

	
	protected DispatcherServlet createDispatcherServlet() throws Exception {
		DispatcherServlet servlet = new DispatcherServlet() {
			@Override
			protected WebApplicationContext createWebApplicationContext(WebApplicationContext parent) throws BeansException {
				GenericWebApplicationContext genericContext = new GenericWebApplicationContext();
				genericContext.setParent(wac);
				genericContext.refresh();
				return genericContext;
			}
		};
		MockServletConfig servletConfig = new MockServletConfig();
		servlet.init(servletConfig);
		return servlet;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	protected <T> T toObjectFromJson(String json, Class<T> valueType) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
//			// always read response as map as that is the format
//			// we expect
			JavaType newValueType = TypeFactory.mapType(Map.class, String.class, valueType);
			Map map = (Map) objectMapper.readValue(json, newValueType);
			return (T) map.values().iterator().next();
		} catch (JsonMappingException e) {
////			if(e.getMessage().equalsIgnoreCase("Can not deserialize instance of java.util.List out of START_OBJECT token")){
////				Collection<T> readValues = new ObjectMapper().readValue(json, new TypeReference<Collection<T>>() { });
////				return (T) readValues;
////			}else
			return objectMapper.readValue(json, valueType);
		}
	}
	
	public <T> T executeTest(HttpMethod method,String uri,Object contentObject, Class<T> responseValueType,Map<String,String> headers, Param... params) throws Exception{
		
		
		if(HttpMethod.POST==method){
		request.setMethod("POST");
		}else if(method == HttpMethod.PUT){
			request.setMethod("PUT");
		}else if(method == HttpMethod.GET){
			request.setMethod("GET");
		}else if(method== HttpMethod.DELETE) {
			request.setMethod("DELETE");
		}
		
		request.setRequestURI(uri);
		request.setPathInfo(uri);
		request.addHeader("Accept", "application/json");
		request.addHeader("Content-Type","application/json");
		
		for (Map.Entry<String, String> entry : headers.entrySet())
		{
		    request.addHeader(entry.getKey(),entry.getValue());
		}
		
		String jsonString="";
		try{
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		 jsonString = objectMapper.writeValueAsString(contentObject);
		}catch(Exception e){
			jsonString = ToStringBuilder.reflectionToString(contentObject);
		}
		
		request.setContent(jsonString.getBytes());
	
		// create dispatcher servlet
				DispatcherServlet servlet = createDispatcherServlet();
				// create response
				MockHttpServletResponse response = new MockHttpServletResponse();
				// invoke servlet
				servlet.service(request, response);
				
				if(responseValueType!=null){
					return  toObjectFromJson(response.getContentAsString(),responseValueType);					
				}else{
					return (T) response.getContentAsString();
				}
					
		

	}

}
