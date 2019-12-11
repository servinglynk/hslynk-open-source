package com.servinglynk.hmis.warehouse.csv.converter;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;

public class BaseCsvConverter {

	protected String getDate(LocalDateTime date) {
		if(date != null) {
			return date.toString();
		}
		return "";
	}
	protected String getId(UUID id) {
		if(id != null) {
			return id.toString();
		}
		return "";
	}
	
	protected List<BaseCSV>  getBaseCSVs(BaseCSV obj) {
		List<BaseCSV> baseCSVs = new ArrayList<BaseCSV>();
		try {
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			field.set(obj, field.getName());
		 }
		}catch(Exception e) { }
		baseCSVs.add(obj);
		return baseCSVs;
	}
	
	
	
	
	protected void hydrateCommonFields(BaseCSV model,HmisBaseModel entity) {
	
	}
}
