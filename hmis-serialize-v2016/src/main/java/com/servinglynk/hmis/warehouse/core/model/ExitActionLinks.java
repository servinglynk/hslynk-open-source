package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

public class ExitActionLinks {

	public List<ExitActionLink> data = new ArrayList<>();
	public String groupBy;
	public List<ExitActionLink> getData() {
		return data;
	}
	public void setData(List<ExitActionLink> data) {
		this.data = data;
	}
	
	public void add(ExitActionLink data) {
		this.data.add(data);
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	
	
}
