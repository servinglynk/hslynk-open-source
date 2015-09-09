package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("oAuthMessageItems")
public class OAuthMessageItems {


	@JsonProperty("oAuthMessageItem")
	private List<OAuthMessageItem> oAuthMessageItems =  new ArrayList<OAuthMessageItem>();

	public List<OAuthMessageItem> getOAuthMessageItems() {
		return oAuthMessageItems;
	}

	public void setOAuthMessageItems(List<OAuthMessageItem> oAuthMessageItems) {
		this.oAuthMessageItems = oAuthMessageItems;
	}

	public void addOAuthMessageItem(OAuthMessageItem oAuthMessageItem) {
		this.oAuthMessageItems.add(oAuthMessageItem);
	}
	
}
