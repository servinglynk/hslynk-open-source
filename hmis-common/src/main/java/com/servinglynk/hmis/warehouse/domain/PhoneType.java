package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * PhoneType entity.
 * 
 */
public class PhoneType extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 22709846722492358L;

	private Integer phoneTypeCd;
	private String phoneTypeName;
	private String phoneTypeDescription;
	private String phoneTypeCode;
	
	/** default constructor */
	public PhoneType() {
	}

	/** minimal constructor */
	public PhoneType(Integer phoneTypeCd, String phoneTypeName) {
		this.phoneTypeCd = phoneTypeCd;
		this.phoneTypeName = phoneTypeName;
	}

	/** full constructor */
	public PhoneType(Integer phoneTypeCd, String phoneTypeName, String phoneTypeDescription) {
		this.phoneTypeCd = phoneTypeCd;
		this.phoneTypeName = phoneTypeName;
		this.phoneTypeDescription = phoneTypeDescription;
	}

	public Integer getPhoneTypeCd() {
		return this.phoneTypeCd;
	}

	public void setPhoneTypeCd(Integer phoneTypeCd) {
		this.phoneTypeCd = phoneTypeCd;
	}

	public String getPhoneTypeName() {
		return this.phoneTypeName;
	}

	public void setPhoneTypeName(String phoneTypeName) {
		this.phoneTypeName = phoneTypeName;
	}

	public String getPhoneTypeDescription() {
		return this.phoneTypeDescription;
	}

	public void setPhoneTypeDescription(String phoneTypeDescription) {
		this.phoneTypeDescription = phoneTypeDescription;
	}

	public String getPhoneTypeCode() {
		return phoneTypeCode;
	}

	public void setPhoneTypeCode(String phoneTypeCode) {
		this.phoneTypeCode = phoneTypeCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PhoneType))
			return false;
		PhoneType castOther = (PhoneType) other;
		return new EqualsBuilder().append(phoneTypeCd, castOther.phoneTypeCd)
				.append(phoneTypeName, castOther.phoneTypeName)
				.append(phoneTypeDescription, castOther.phoneTypeDescription)
				.append(phoneTypeCode, castOther.phoneTypeCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(phoneTypeCd).append(phoneTypeName).append(phoneTypeDescription).append(
				phoneTypeCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("phoneTypeCd", phoneTypeCd).append("phoneTypeName", phoneTypeName).append(
				"phoneTypeDescription", phoneTypeDescription).append("phoneTypeCode", phoneTypeCode).toString();
	}
}