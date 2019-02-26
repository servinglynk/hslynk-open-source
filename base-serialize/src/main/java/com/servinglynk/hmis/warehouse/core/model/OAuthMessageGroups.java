package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("oAuthMessageGroups")
public class OAuthMessageGroups {

	@JsonProperty(value="oAuthMessageGroup")
	private List<OAuthMessageGroup> oAuthMessageGroups =  new ArrayList<OAuthMessageGroup>();

	public List<OAuthMessageGroup> getoAuthMessageGroups() {
		return oAuthMessageGroups;
	}

	public void setoAuthMessageGroups(List<OAuthMessageGroup> oAuthMessageGroups) {
		this.oAuthMessageGroups = oAuthMessageGroups;
	}

	public void addOAuthMessageGroup(OAuthMessageGroup oAuthMessageGroup) {
		if (oAuthMessageGroups == null) this.oAuthMessageGroups = new ArrayList<OAuthMessageGroup>();
		this.oAuthMessageGroups.add(oAuthMessageGroup);
	}
}

