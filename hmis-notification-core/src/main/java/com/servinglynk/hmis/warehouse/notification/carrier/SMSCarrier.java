package com.servinglynk.hmis.warehouse.notification.carrier;

public class SMSCarrier implements ICarrier{
	
	public void send(CarrierNotification carrierNotification){
		System.out.println("sent SMS");
}
}
