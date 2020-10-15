package com.servinglynk.hmis.warehouse.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.servinglynk.hmis.entity.SubscriptionEntity;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.service.publish.handler.PublishHandlerFactory;

@Service
public class EventServiceImpl extends BaseService implements EventService {
	@Autowired
	PublishHandlerFactory handlerFactory;

	@Transactional
	public void processEvent(AMQEvent event) throws Exception {
		JSONObjectMapper mapper = new JSONObjectMapper();
		String projecrGrouCode = (String) event.getPayload().get("projectGroupCode");
		String requestUrl = ((String) event.getPayload().get("requestUrl")).replace("/hmis-clientapi-", "").replace("/rest", "");
		List<SubscriptionEntity> entities = daoFactory.getSubscriptionRepository()
				.findByCriteriaUrlAndProjectGroupCodeAndDeleted(requestUrl, projecrGrouCode, false);
		Map<String, Object> requestBody =  (Map<String, Object>) event.getPayload().get("reqestBody");
		Object obj = new JSONParser().parse(mapper.writeValueAsString(requestBody).toLowerCase());
		JSONObject jsonObject = (JSONObject) obj;
		for (SubscriptionEntity entity : entities) {
			UriComponents uriComponents = null;
			uriComponents = UriComponentsBuilder.newInstance().fromHttpUrl("http://api.hslynk.com/"+entity.getCriteria()).build();

			Map<String, List<String>> queryParams = uriComponents.getQueryParams();
			Boolean validated = false;
			for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
				if (jsonObject.containsKey(entry.getKey().toLowerCase())) {
					if (entry.getValue().contains(jsonObject.get(entry.getKey().toLowerCase()).toString()))
						validated = true;
				}
			}

			if (validated) {
				handlerFactory.getPublisher(entity.getChannelType().toLowerCase()).publish(entity);
			}
		}
	}
	
	
	public static void main(String args[]) {
		String url = "v2020/clients​/{clientid}​/enrollments​/{enrollmentid}?chronicHomeless=1&_format=json";
		System.out.println(url.substring(0,url.indexOf("?")));
	}
}
