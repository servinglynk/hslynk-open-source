package com.servinglynk.hmis.warehouse.client.reportservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.servinglynk.hmis.warehouse.client.base.CoreClientBase;
import com.servinglynk.hmis.warehouse.client.config.CoreClientConfig;
import com.servinglynk.hmis.warehouse.client.exception.RestClientHttpException;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.core.model.ReportRequest;




public class ReportServiceClient extends CoreClientBase implements IReportServiceClient {
	final static Logger logger = Logger.getLogger(ReportServiceClient.class);

	/** Surya 04/13/2015 
	 * serviceURL is the URL where the notification service is deployed (different host) */
	
	@Autowired
	CoreClientConfig coreClientConfig;

	public ReportRequest createReport(ReportRequest reportRequest) throws RestClientHttpException {
		
		HttpHeaders headers = getHttpHeaders();
	
		logger.debug(reportRequest.toString());
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new JSONObjectMapper());

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(createXmlHttpMessageConverter());
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		
  		HttpEntity<ReportRequest> requestEntity = new HttpEntity<ReportRequest>(reportRequest, headers);
  		ReportRequest responseEntity = restTemplate.postForObject(coreClientConfig.getReportServiceUrl() + "/reports", requestEntity, ReportRequest.class);
		
		

		return responseEntity;
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
