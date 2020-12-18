package com.servinglynk.hmis.model;

public abstract class ClientModel {
	
	/* @Override
	public String toString() {
		try{
			 return ToStringBuilder.reflectionToString(this);
		}catch(Exception e){ }
		
		return null;
	}
	
	public String toJSONString() throws Exception {
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		String jsonString = objectMapper.writeValueAsString(this);
		return jsonString;
	} */
	
	private InventorySummary summary;

	public InventorySummary getSummary() {
		return summary;
	}

	public void setSummary(InventorySummary summary) {
		this.summary = summary;
	}
}
