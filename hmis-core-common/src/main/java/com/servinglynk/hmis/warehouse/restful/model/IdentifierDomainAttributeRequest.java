package com.servinglynk.hmis.warehouse.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.servinglynk.hmis.warehouse.domain.IdentifierDomain;


@XmlRootElement
public class IdentifierDomainAttributeRequest
{
	private IdentifierDomain identifierDomain;
	private String attributeName;
	private String attributeValue;
	
	public IdentifierDomainAttributeRequest() {
	}

	public IdentifierDomainAttributeRequest(IdentifierDomain identifierDomain, String attributeName) {
		this.identifierDomain = identifierDomain;
		this.attributeName = attributeName;
	}

	public IdentifierDomainAttributeRequest(IdentifierDomain identifierDomain, String attributeName,  String attributeValue) {
		this.identifierDomain = identifierDomain;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	} 
	
	public IdentifierDomain getIdentifierDomain() {
		return identifierDomain;
	}
	public void setIdentifierDomain(IdentifierDomain identifierDomain) {
		this.identifierDomain = identifierDomain;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	@Override
	public String toString() {
		return "IdentifierDomainAttributeRequest [identifierDomain="
				+ identifierDomain + ", attributeName=" + attributeName + "]";
	}
}
