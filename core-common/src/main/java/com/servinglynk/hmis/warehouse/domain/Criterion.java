package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Criterion extends BaseObject
{
	private static final long serialVersionUID = 2658973973160456090L;

	private String name;
	private Operation operation;
	private Object value;
	
	public Criterion() {
	}
	
	public Criterion(String name, Operation operation, Object value) {
		this.name = name;
		this.operation = operation;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Criterion))
			return false;
		Criterion castOther = (Criterion) other;
		return new EqualsBuilder().append(name, castOther.name).append(operation, castOther.operation).append(value,
				castOther.value).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(operation).append(value).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("operation", operation).append("value", value)
				.toString();
	}

}
