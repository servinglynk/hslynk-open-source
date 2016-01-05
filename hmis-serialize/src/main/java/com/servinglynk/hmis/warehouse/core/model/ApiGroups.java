package com.servinglynk.hmis.warehouse.core.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonRootName;

@XmlType(name = "ApiGroups")
@XmlRootElement(name = "apiGroups")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("apiGroups")
public class ApiGroups	{

	@XmlElements( { @XmlElement(name = "apiGroup", type = ApiGroup.class) })
	private List<ApiGroup> apiGroups;

	public List<ApiGroup> getApiGroups() {
		return apiGroups;
	}
	public void setApiGroups(List<ApiGroup> apiGroups) {
		this.apiGroups = apiGroups;
	}
}
