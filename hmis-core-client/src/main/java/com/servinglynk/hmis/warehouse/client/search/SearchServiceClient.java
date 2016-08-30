package com.servinglynk.hmis.warehouse.client.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.servinglynk.hmis.warehouse.client.base.CoreClientBase;
import com.servinglynk.hmis.warehouse.client.model.BaseProject;
import com.servinglynk.hmis.warehouse.client.model.SearchRequest;

public class SearchServiceClient extends CoreClientBase implements ISearchServiceClient {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<?> search(SearchRequest request) throws Exception {
		
		List<?> searchElements = new ArrayList<>();
		
		HttpHeaders headers = getHttpHeaders();
		headers.add("X-HMIS-TrustedApp-Id", request.getTrustedAppId());
		headers.add("Authorization","HMISUserAuth session_token="+request.getSessionToken());
	
		
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
	//	restTemplate.setMessageConverters(messageConverters);

		HttpEntity entity = new HttpEntity(headers);
		
		StringBuffer URI =new StringBuffer("http://52.38.189.237:8080/hmis-clientapi-v2014/rest/searchall/projects?");
		for (Map.Entry<String, Object> entry : request.getSearchParams().entrySet())
		{
		   URI.append("&"+entry.getKey()+"="+entry.getValue());
		}
		
		ResponseEntity<String> response = restTemplate.exchange(URI.toString(),HttpMethod.GET,entity ,String.class);
		

			ObjectMapper mapper2 = new ObjectMapper();			
			JsonNode root =  mapper2.readTree(response.getBody());
		

			searchElements =  mapper2.readValue(root.get("searchResults").get("items").traverse(),TypeFactory.defaultInstance().constructCollectionType(List.class, BaseProject.class));

		return searchElements;
	}
	
	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = 
          new MarshallingHttpMessageConverter();
 
        
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
 
        return xmlConverter;
	}

	
/*	public static void main(String args[]) throws Exception {
		try{
		SearchRequest request = new SearchRequest();
		request.setSessionToken("C67BB2C58F32440F8A9F610F01CC38555945DA2F97584620B3516E49C52CDF6C");
		request.setTrustedAppId("MASTER_TRUSTED_APP");
		SearchServiceClient client = new SearchServiceClient();
		request.addSearchParam("q", "67ee2c7a-ec03-421f-802d-d73e02c3924a");
		List<BaseProject> projects =   (List<BaseProject>) client.search(request);
		System.out.println(projects.size());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
