package com.servinglynk.hmis.warehouse.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("hmisPosting")
public class HmisPostingsModel {

	private HmisPostingModel hmisPosting;

	public HmisPostingModel getHmisPosting() {
		return hmisPosting;
	}

	public void setHmisPosting(HmisPostingModel hmisPosting) {
		this.hmisPosting = hmisPosting;
	}
	
}
