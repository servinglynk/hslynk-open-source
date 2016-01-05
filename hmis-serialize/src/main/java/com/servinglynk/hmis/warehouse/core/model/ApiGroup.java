package com.servinglynk.hmis.warehouse.core.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonRootName;

@XmlType(name = "ApiGroup")
@XmlRootElement(name = "apiGroup")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("apiGroup")
public class ApiGroup	{

	@XmlElement(name = "apiGroupId")
	private String externalId;

	@XmlElement(name = "friendlyName")
	private String friendlyName;

	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "authorizationMsg")
	private String authorizationMsg;

	@XmlElement(name = "sequence")
	private Long groupSequence;

	@XmlElementWrapper(name = "apiMethods")
	@XmlElements( { @XmlElement(name = "apiMethod", type = ApiMethod.class) })
	private List<ApiMethod> apiMethods;

	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthorizationMsg() {
		return authorizationMsg;
	}
	public void setAuthorizationMsg(String authorizationMsg) {
		this.authorizationMsg = authorizationMsg;
	}
	public Long getGroupSequence() {
		return groupSequence;
	}
	public void setGroupSequence(Long groupSequence) {
		this.groupSequence = groupSequence;
	}
	public List<ApiMethod> getApiMethods() {
		return apiMethods;
	}
	public void setApiMethods(List<ApiMethod> apiMethods) {
		this.apiMethods = apiMethods;
	}
}
