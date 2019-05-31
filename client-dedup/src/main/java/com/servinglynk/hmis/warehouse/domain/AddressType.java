
package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AddressType extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 7714813422902045544L;

	private Integer addressTypeCd;
	private String addressTypeName;
	private String addressTypeDescription;
	private String addressTypeCode;

	/** default constructor */
	public AddressType() {
	}

	/** minimal constructor */
	public AddressType(Integer addressTypeCd, String addressTypeName) {
		this.addressTypeCd = addressTypeCd;
		this.addressTypeName = addressTypeName;
	}

	/** full constructor */
	public AddressType(Integer addressTypeCd, String addressTypeName, String addressTypeDescription, String addressTypeCode) {
		this.addressTypeCd = addressTypeCd;
		this.addressTypeName = addressTypeName;
		this.addressTypeDescription = addressTypeDescription;
		this.addressTypeCode = addressTypeCode;
	}

	public Integer getAddressTypeCd() {
		return this.addressTypeCd;
	}

	public void setAddressTypeCd(Integer addressTypeCd) {
		this.addressTypeCd = addressTypeCd;
	}

	public String getAddressTypeName() {
		return this.addressTypeName;
	}

	public void setAddressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
	}

	public String getAddressTypeDescription() {
		return this.addressTypeDescription;
	}

	public void setAddressTypeDescription(String addressTypeDescription) {
		this.addressTypeDescription = addressTypeDescription;
	}

	public String getAddressTypeCode() {
		return addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AddressType))
			return false;
		AddressType castOther = (AddressType) other;
		return new EqualsBuilder().append(addressTypeCd, castOther.addressTypeCd).append(addressTypeName,
				castOther.addressTypeName).append(addressTypeDescription, castOther.addressTypeDescription).append(
				addressTypeCode, castOther.addressTypeCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(addressTypeCd).append(addressTypeName).append(addressTypeDescription)
				.append(addressTypeCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("addressTypeCd", addressTypeCd).append("addressTypeName",
				addressTypeName).append("addressTypeDescription", addressTypeDescription).append("addressTypeCode",
				addressTypeCode).toString();
	}

}