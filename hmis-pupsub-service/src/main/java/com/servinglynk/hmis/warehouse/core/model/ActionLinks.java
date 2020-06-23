package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ActionLinks {

//	public List<ActionLink> links = new ArrayList<ActionLink>();
	public List<ActionLink> data = new ArrayList<ActionLink>();
	
//	private List<UUID> ids = new ArrayList<>();
	private String groupBy;

	public List<ActionLink> getData() {
		return data;
	}

	public void setData(List<ActionLink> data) {
		this.data = data;
	}
	
	public void addLink(ActionLink actionLink) {
		this.data.add(actionLink);
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String goupedBy) {
		this.groupBy = goupedBy;
	}

/*	public List<UUID> getIds() {
		return ids;
	}

	public void setIds(List<UUID> ids) {
		this.ids = ids;
	}
	
	public void addId(UUID id) {
		this.ids.add(id);
	}*/
}