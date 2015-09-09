package com.servinglynk.hmis.warehouse.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataProfileAttributeValue extends BaseObject
{
	private static final long serialVersionUID = -5805814946755578692L;
	
	private Integer attributeValueId;
	private Integer attributeId;
	private String attributeValue;
	private Integer frequency;
	
	public DataProfileAttributeValue() {
	}
	
	public DataProfileAttributeValue(Integer attributeValueId) {
		this.attributeValueId = attributeValueId;
	}
	
	public DataProfileAttributeValue(Integer attributeValueId, Integer attributeId, String attributeValue,
			Integer frequency) {
		this.attributeValueId = attributeValueId;
		this.attributeId = attributeId;
		this.attributeValue = attributeValue;
		this.frequency = frequency;
	}

	public Integer getAttributeValueId() {
		return attributeValueId;
	}

	public void setAttributeValueId(Integer attributeValueId) {
		this.attributeValueId = attributeValueId;
	}
	
	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataProfileAttributeValue other = (DataProfileAttributeValue) obj;
		if (attributeValueId == null) {
			if (other.attributeValueId != null)
				return false;
		} else if (!attributeValueId.equals(other.attributeValueId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeValueId == null) ? 0 : attributeValueId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "DataProfileAttributeValue [attributeValueId=" + attributeValueId + ", attributeId=" + attributeId
				+ ", attributeValue=" + attributeValue + ", frequency=" + frequency + "]";
	}
}
