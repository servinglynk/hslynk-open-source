package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("trustedApps")
public class TrustedApps extends PaginatedModel	{


	@JsonProperty("trustedApp")
	private List<TrustedApp> trustedApps;

	public List<TrustedApp> getTrustedApps() {
		return trustedApps;
	}

	public void setTrustedApps(List<TrustedApp> trustedApps) {
		this.trustedApps = trustedApps;
	}

	
	public void addTrustedApp(TrustedApp trustedApp) {
		if(this.trustedApps==null) trustedApps = new ArrayList<TrustedApp>();
		this.trustedApps.add(trustedApp);
	}
	
}
