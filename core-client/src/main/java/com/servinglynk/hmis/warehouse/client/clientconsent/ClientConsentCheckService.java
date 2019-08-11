package com.servinglynk.hmis.warehouse.client.clientconsent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.servinglynk.hmis.warehouse.client.base.CoreClientBase;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;

public class ClientConsentCheckService extends CoreClientBase implements IClientConsentCheckService {
	
	final static Logger logger = Logger.getLogger(ClientConsentCheckService.class);
	
	@Autowired Environment env;

	public Boolean checkClientConsentForUser(ApiMethodAuthorizationCheck authCheck,UUID clientId) throws Exception {
		HttpHeaders headers = getHttpHeaders();
		headers.add("X-HMIS-TrustedApp-Id", authCheck.getTrustedAppId());
		headers.add("Authorization","HMISUserAuth session_token="+authCheck.getAccessToken());
	
		logger.debug(authCheck.toString());
		
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

		HttpEntity entity = new HttpEntity(headers);
//		 ResponseEntity<Boolean> response = restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-user-service/rest/apimethodauthcheck/"+authCheck.getApiMethodId(),HttpMethod.GET,entity ,Boolean.class);

		 ResponseEntity<String> response = restTemplate.exchange(env.getProperty("elbhost")+"/hmis-globalapi/rest//clients/"+clientId+"/checkUserConsent",HttpMethod.GET,entity ,String.class);
		
		 if(response.getStatusCode().equals("200"))
			 return new Boolean(response.getBody());
		 else
			 return false;
		 
	}
	
	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = 
          new MarshallingHttpMessageConverter();
 
        
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
 
        return xmlConverter;
	}
	
	public static void main(String args[]) throws Exception {
	ApiMethodAuthorizationCheck auth = new ApiMethodAuthorizationCheck();
	auth.setAccessToken("C282CCB8DA0A4BA3AE623541EF2EC56340AD87232F5D48538962EC5AA2527F5A");
	auth.setTrustedAppId("MASTER_TRUSTED_APP");
	UUID clientId = UUID.fromString("b023a85e-bd51-49c4-b26e-aa489db1e32a");
		ClientConsentCheckService client = new ClientConsentCheckService();
		System.out.println(client.checkClientConsentForUser(auth, clientId));
		
	}
	
}