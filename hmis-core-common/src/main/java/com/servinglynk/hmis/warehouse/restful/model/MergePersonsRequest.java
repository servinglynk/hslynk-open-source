package com.servinglynk.hmis.warehouse.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.servinglynk.hmis.warehouse.domain.PersonIdentifier;

@XmlRootElement
public class MergePersonsRequest
{
	private PersonIdentifier retiredIdentifier;
	private PersonIdentifier survivingIdentifer;
	
	public MergePersonsRequest() {
	}

	public MergePersonsRequest(PersonIdentifier retiredIdentifier, PersonIdentifier survivingIdentifer) {
		this.retiredIdentifier = retiredIdentifier;
		this.survivingIdentifer = survivingIdentifer;
	}
	
	public PersonIdentifier getRetiredIdentifier() {
		return retiredIdentifier;
	}
	public void setRetiredIdentifier(PersonIdentifier retiredIdentifier) {
		this.retiredIdentifier = retiredIdentifier;
	}

	public PersonIdentifier getSurvivingIdentifer() {
		return survivingIdentifer;
	}
	public void setSurvivingIdentifer(PersonIdentifier survivingIdentifer) {
		this.survivingIdentifer = survivingIdentifer;
	}
	
	@Override
	public String toString() {
		return "MergePersonsRequest [retiredIdentifier="
				+ retiredIdentifier + ", survivingIdentifer=" + survivingIdentifer + "]";
	}
}
