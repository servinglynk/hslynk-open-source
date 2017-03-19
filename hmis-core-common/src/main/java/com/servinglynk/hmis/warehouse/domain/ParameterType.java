package com.servinglynk.hmis.warehouse.domain;

import java.util.Arrays;

public class ParameterType extends BaseObject
{
	private static final long serialVersionUID = -871692721916993525L;

	private String name;
	private String displayName;
	private FormEntryDisplayType displayType;
	private Object[] valueList;

	public ParameterType(String name, String displayName, FormEntryDisplayType displayType, Object[] values) {
		this.name = name;
		this.displayName = displayName;
		this.displayType = displayType;
	}
	
	public ParameterType(String name, String displayName, FormEntryDisplayType displayType) {
		this.name = name;
		this.displayName = displayName;
		this.displayType = displayType;
	}
	
	public ParameterType(String name, FormEntryDisplayType displayType, Object[] values) {
		this.name = name;
		this.displayType = displayType;
	}

	public ParameterType(String name, FormEntryDisplayType displayType) {
		this.name = name;
		this.displayType = displayType;
	}

	public ParameterType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public FormEntryDisplayType getDisplayType() {
		return displayType;
	}

	public void setDisplayType(FormEntryDisplayType displayType) {
		this.displayType = displayType;
	}

	public Object[] getValueList() {
		return valueList;
	}

	public void setValueList(Object[] valueList) {
		this.valueList = valueList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParameterType other = (ParameterType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ParameterType [name=" + name + ", displayName=" + displayName + ", displayType=" + displayType
				+ ", valueList=" + Arrays.toString(valueList) + "]";
	}

}
