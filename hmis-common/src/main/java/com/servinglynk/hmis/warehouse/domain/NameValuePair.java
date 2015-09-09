package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * NameValuePair encapsulates the combination of a column or attribute with its corresponding value
 * 
 */
public class NameValuePair extends BaseObject
{
	private static final long serialVersionUID = -4012644666481353904L;
	
	private String name;
	private Object value;
	
	public NameValuePair() {
	}

	public NameValuePair(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof NameValuePair))
			return false;
		NameValuePair castOther = (NameValuePair) other;
		return new EqualsBuilder().append(name, castOther.name).append(value, castOther.value).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(value).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("value", value).toString();
	}
}
