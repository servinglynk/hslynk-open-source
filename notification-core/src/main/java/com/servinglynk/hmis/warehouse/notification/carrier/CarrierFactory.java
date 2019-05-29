package com.servinglynk.hmis.warehouse.notification.carrier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationMethod;

@Component
public class CarrierFactory {
	
	@Autowired
	protected SMSCarrier smsCarrier;
	public SMSCarrier getSmsCarrier() {
		return smsCarrier;
	}

	public void setSmsCarrier(SMSCarrier smsCarrier) {
		this.smsCarrier = smsCarrier;
	}

	public EMailCarrier getEmailCarrier() {
		return emailCarrier;
	}

	public void setEmailCarrier(EMailCarrier emailCarrier) {
		this.emailCarrier = emailCarrier;
	}

	@Autowired
	protected EMailCarrier emailCarrier;
		
	 public ICarrier getCarrier(NotificationMethod method){
		 
		 if(method.equals(NotificationMethod.EMAIL)) 
			 return emailCarrier;
		 
		 if(method.equals(NotificationMethod.SMS)) 
			 return smsCarrier;
		 
		 return null;
	 }
}
