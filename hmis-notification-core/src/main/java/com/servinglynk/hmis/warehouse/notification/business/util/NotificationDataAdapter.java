package com.servinglynk.hmis.warehouse.notification.business.util;


	
	import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;
	  
	public final class NotificationDataAdapter extends  XmlAdapter<MapType,Map<String, Object>> {
	  
	   @Override
	   public MapType marshal(Map<String, Object> arg0) throws Exception {
		   MapType myMapType = new MapType();
	      for(Entry<String, Object> entry : arg0.entrySet()) {
	         MapEntryType myMapEntryType = 
	            new MapEntryType();
	         myMapEntryType.key = entry.getKey();
	         myMapEntryType.value = entry.getValue();
	         myMapType.entry.add(myMapEntryType);
	      }
	      return myMapType;
	   }
	  
	   @Override
	   public Map<String, Object> unmarshal(MapType arg0) throws Exception {
	      HashMap<String, Object> hashMap = new HashMap<String, Object>();
	      for(MapEntryType myEntryType : arg0.entry) {
	         hashMap.put(myEntryType.key, myEntryType.value);
	      }
	      return hashMap;
	   }
	  
	}

