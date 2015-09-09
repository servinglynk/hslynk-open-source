package com.servinglynk.hmis.warehouse.core.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

// Test report model for AHAR Model
public class AHARModel extends ClientModel{

	private Integer id;
	private Date date;
	
	
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	@Override
	public String toString() {
		try{
			return ToStringBuilder.reflectionToString(this);
		}catch(Exception e){ }
		return null;
	}
	
	
}
