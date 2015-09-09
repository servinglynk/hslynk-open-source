package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("redirectUris")
public class RedirectUris extends PaginatedModel	{


	@JsonProperty("redirectUri")
	private List<RedirectUri> redirectUris = new ArrayList<RedirectUri>();

	public List<RedirectUri> getRedirectUris() {
		return redirectUris;
	}

	public void setRedirectUris(List<RedirectUri> redirectUris) {
		this.redirectUris = redirectUris;
	}
	
	public void addRedirectUri(RedirectUri redirectUri) {
		if (redirectUris == null) this.redirectUris = new ArrayList<RedirectUri>();
		redirectUris.add(redirectUri);
	}
}
