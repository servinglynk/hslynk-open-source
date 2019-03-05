package com.servinglynk.hmis.warehouse.test.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.tags.Param;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.core.model.Profiles;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.test.core.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
public class TestJUnitTesting<T> {
	
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
	
	@SuppressWarnings("unchecked")
	protected <T> T toObjectFromJson(String json, Class<T> valueType) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	return (T) objectMapper.readValue(json, Profiles.class);
	}
	
	
	
	public String executeTest(HttpMethod method,String uri,Object contentObject, Class<T> responseValueType,Map<String,String> headers, Param... params) throws Exception{
		
		
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

		
		return "";
	}
	
	@Test
	public void test() throws Exception {
		//MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		Role role= TestData.getRole();
		
	//	request.addHeader("accessToken","HMISHNUserAuth session_token=CD721B0A6C03483AA0ADD36E1BADA6B83FEEB4483442462F93B5D8F92FE6CAF2");
	//	request.addHeader("trustedAppId", "631D1191-9AC5-4F3F-836A-8DB0DBAE3CD3");

	//	ResultActions mvcResult =	 mockMvc.perform(get("/profiles"));
	
		request.setMethod("POST");
		request.setRequestURI("/roles");
		request.setPathInfo("/roles");
		request.addHeader("Accept", "application/json");
		request.addHeader("Content-Type","application/json");
		
		request.setContent(role.toJSONString().getBytes());
		JSONObjectMapper mapper = new JSONObjectMapper();

		// create dispatcher servlet
				DispatcherServlet servlet = createDispatcherServlet();
				// create response
				MockHttpServletResponse response = new MockHttpServletResponse();
				// invoke servlet
				servlet.service(request, response);
				Profiles profiles = toObjectFromJson(response.getContentAsString(), Profiles.class);
				
		System.out.println("Profile Name is "+profiles.toString());
	}
	
	
	
	public void createUser() throws Exception {
		
		
	}
	
	
	
	
}
