package com.servinglynk.hmis.warehouse.notification.framework;



import java.util.HashMap;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.servinglynk.hmis.warehouse.notification.model.ClientModel;

@XmlType(name = "NotificationData")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationData extends ClientModel {
	
	@XmlElement(name = "data")
	HashMap<String,Object> data = new HashMap<String,Object>();
	
	public void addDataElement(String key, String value){
		data.put(key, value);
	}
	
	public Object getDataElement(String key){
		return data.get(key);
	}
	
	private Set<String> dataElementNames(){
		return (Set<String>)data.keySet();
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	

	
	
}

