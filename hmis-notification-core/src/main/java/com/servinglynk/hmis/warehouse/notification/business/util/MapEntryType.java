package com.servinglynk.hmis.warehouse.notification.business.util;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
 
public class MapEntryType {
 
   @XmlAttribute
   public String key; 
 
   @XmlValue
   public Object value;
 
}