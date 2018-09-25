package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class ActionLinks {

	public List<ActionLink> links = new ArrayList<ActionLink>();

	public List<ActionLink> getLinks() {
		return links;
	}

	public void setLinks(List<ActionLink> links) {
		this.links = links;
	}
	
	public void addLink(ActionLink actionLink) {
		this.links.add(actionLink);
	}
}