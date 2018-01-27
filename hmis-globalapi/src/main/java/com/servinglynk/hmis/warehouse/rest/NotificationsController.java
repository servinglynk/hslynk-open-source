package com.servinglynk.hmis.warehouse.rest;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.NotificationSearchRequest;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.HmisNotification;
import com.servinglynk.hmis.warehouse.core.model.HmisNotifications;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRequest;
import com.servinglynk.hmis.warehouse.validator.EmailValidator;

@RestController
@RequestMapping("/notifications")
public class NotificationsController extends ControllerBase {

	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public HmisNotification sendEmailNotification(@Valid @RequestBody HmisNotification hmisNotification,HttpServletRequest request,HttpServletResponse response) throws Exception {

		hmisNotification.getData().getRecipients().getBccRecipients().removeAll(Collections.singletonList(""));
		hmisNotification.getData().getRecipients().getBccRecipients().removeAll(Collections.singletonList(" "));
		hmisNotification.getData().getRecipients().getBccRecipients().removeAll(Collections.singletonList(null));
		
		hmisNotification.getData().getRecipients().getCcRecipients().removeAll(Collections.singletonList(""));
		hmisNotification.getData().getRecipients().getCcRecipients().removeAll(Collections.singletonList(" "));
		hmisNotification.getData().getRecipients().getCcRecipients().removeAll(Collections.singletonList(null));
		
		hmisNotification.getData().getRecipients().getToRecipients().removeAll(Collections.singletonList(""));
		hmisNotification.getData().getRecipients().getToRecipients().removeAll(Collections.singletonList(" "));
		hmisNotification.getData().getRecipients().getToRecipients().removeAll(Collections.singletonList(null));
		
		Set<String> errorReciepents = new HashSet<String>();
		
		for(String email: hmisNotification.getData().getRecipients().getToRecipients()) {
			boolean flag =	EmailValidator.validate(email);
			if(!flag) errorReciepents.add("TO");
		}
		
		for(String email: hmisNotification.getData().getRecipients().getCcRecipients()) {
			boolean flag =	EmailValidator.validate(email);
			if(!flag) errorReciepents.add("CC");
		}
		
		for(String email: hmisNotification.getData().getRecipients().getBccRecipients()) {
			boolean flag =	EmailValidator.validate(email);
			if(!flag) errorReciepents.add("BCC");
		}

		if(!errorReciepents.isEmpty()) throw new InvalidRequest(" Invalid email addresses in "+errorReciepents.toString());
		
		Session session = sessionHelper.getSession(request);
		serviceFactory.getHmisNotificationsService().sendHmisNotification(hmisNotification, session.getAccount());
		
		return hmisNotification;
	}
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public HmisNotifications getEmailNotifications(
			
			@RequestParam(value="recipienttype",required=false) String recipientType,
			@RequestParam(value="recipientid",required=false) String recipientId,
			@RequestParam(value="status",required=false) List<String> status,
			@RequestParam(value="fromdate",required=false) Long fromDate,
			@RequestParam(value="todate",required=false) Long toDate,
			@RequestParam(value="startIndex", required=false,defaultValue="0") Integer startIndex, 
            @RequestParam(value="maxItems", required=false,defaultValue="200") Integer maxItems,
			HttpServletRequest request
			) throws Exception {
		NotificationSearchRequest searchRequest = new NotificationSearchRequest();
		if(fromDate!=null) searchRequest.setFromDate(new Date(fromDate));
		if(toDate!=null) searchRequest.setToDate(new Date(toDate));
		if(status!=null) searchRequest.setStatus(status);
		if(recipientType!=null) searchRequest.setRecipientType(recipientType);
		if(recipientId!=null) searchRequest.setRecipientId(recipientId);
		Session session = sessionHelper.getSession(request);
		searchRequest.setStartIndex(startIndex);
		searchRequest.setMaxItems(maxItems);
		searchRequest.setProjectGroup(session.getAccount().getProjectGroup().getProjectGroupCode());
		
		return serviceFactory.getHmisNotificationsService().getEmailNotifications(searchRequest);
	}
	
	
	
/*	public static void main(String args[]) throws Exception  {
		HmisNotification notification = new HmisNotification();
		notification.setMessage("Test message");
		notification.setMessageType("Test type");
		notification.setMethod("email");
		notification.setRecipientId("tets");
		notification.setRecipientType("test");
		notification.setSubject("Test subject");
		notification.getRecipients().addToRecipient("narayana880@gmail.com");
		notification.getRecipients().addBccRecipient("narayana880@gmail.com");
		notification.getRecipients().addCcRecipient("narayana880@gmail.com");
		
		System.out.println("" +notification.toJSONString());
		
		
	}*/
	
}