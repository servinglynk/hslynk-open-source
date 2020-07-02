package com.servinglynk.hmis.warehouse.rest.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;

public class ApiMehtodAuthCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private SessionHelper sessionHelper;
	
	@Autowired
	private TrustedAppHelper trustedAppHelper;
	
	@Autowired Environment env;
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = null;
		handlerMethod = (HandlerMethod) handler;
		
		String accessToken = this.sessionHelper.retrieveSessionToken(request);
		String trustedApp = this.trustedAppHelper.retrieveTrustedAppId(request);

		APIMapping apiMapping = handlerMethod.getMethodAnnotation(APIMapping.class);
		if(apiMapping!=null) {
			if(apiMapping.value().equalsIgnoreCase("HEALTH_CHECK")) return true;
			ApiMethodAuthorizationCheck apiMethodAuthorizationCheck = new ApiMethodAuthorizationCheck();
			apiMethodAuthorizationCheck.setApiMethodId(apiMapping.value());
			apiMethodAuthorizationCheck.setAccessToken(accessToken);
			apiMethodAuthorizationCheck.setTrustedAppId(trustedApp);
			// client = new AuthorizationServiceClient();
			ApiMethodAuthorizationCheck clientresponse = this.checkApiAuthorization(apiMethodAuthorizationCheck);
		
			com.servinglynk.hmis.warehouse.core.model.Session session = new com.servinglynk.hmis.warehouse.core.model.Session();
			session.setToken(clientresponse.getAccessToken());
			session.setAccount(clientresponse.getAccount());
			this.sessionHelper.setSession(session, request);
			this.trustedAppHelper.setTrustedApp(clientresponse.getTrustedApp(), request);
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(session, ""));
			return true;
		}else{
			
			return false;
		}
	}
	
	
	
	public ApiMethodAuthorizationCheck checkApiAuthorization(ApiMethodAuthorizationCheck authCheck) throws Exception {
		RestTemplate restTemplate = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("X-HMIS-TrustedApp-Id", authCheck.getTrustedAppId());
		headers.add("Authorization","HMISUserAuth session_token="+authCheck.getAccessToken());
	
		System.out.println(authCheck.toString());
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		
		converter.setObjectMapper(mapper);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(createXmlHttpMessageConverter());
		messageConverters.add(converter);
		restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);

		System.out.println("Authorization url "+env.getProperty("elbhost")+"/hmis-user-service/rest/apimethodauthcheck/"+authCheck.getApiMethodId());
		HttpEntity entity = new HttpEntity(headers);
		 ResponseEntity<ApiMethodAuthorizationCheck> response = restTemplate.exchange(env.getProperty("elbhost")+"/hmis-user-service/rest/apimethodauthcheck/"+authCheck.getApiMethodId(),HttpMethod.GET,entity ,ApiMethodAuthorizationCheck.class);
		if(response.getStatusCodeValue() == 200) {
			return response.getBody();
		}else {
//			mapper.readValue(response.getBody(), Errors.class);
			return null;
		}

	}

	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = 
          new MarshallingHttpMessageConverter();
 
        
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
 
        return xmlConverter;
	}

}
