package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * NameType entity.
 * 
 */
public class NameType extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 6170253797278224912L;

	private Integer nameTypeCd;
	private String nameTypeName;
	private String nameTypeDescription;
	private String nameTypeCode;
	
	/** default constructor */
	public NameType() {
	}

	/** minimal constructor */
	public NameType(Integer nameTypeCd, String nameTypeName) {
		this.nameTypeCd = nameTypeCd;
		this.nameTypeName = nameTypeName;
	}

	/** full constructor */
	public NameType(Integer nameTypeCd, String nameTypeName, String nameTypeDescription) {
		this.nameTypeCd = nameTypeCd;
		this.nameTypeName = nameTypeName;
		this.nameTypeDescription = nameTypeDescription;
	}

	public Integer getNameTypeCd() {
		return this.nameTypeCd;
	}

	public void setNameTypeCd(Integer nameTypeCd) {
		this.nameTypeCd = nameTypeCd;
	}

	public String getNameTypeName() {
		return this.nameTypeName;
	}

	public void setNameTypeName(String nameTypeName) {
		this.nameTypeName = nameTypeName;
	}

	public String getNameTypeDescription() {
		return this.nameTypeDescription;
	}

	public void setNameTypeDescription(String nameTypeDescription) {
		this.nameTypeDescription = nameTypeDescription;
	}

	public String getNameTypeCode() {
		return nameTypeCode;
	}

	public void setNameTypeCode(String nameTypeCode) {
		this.nameTypeCode = nameTypeCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof NameType))
			return false;
		NameType castOther = (NameType) other;
		return new EqualsBuilder().append(nameTypeCd, castOther.nameTypeCd)
				.append(nameTypeName, castOther.nameTypeName)
				.append(nameTypeDescription, castOther.nameTypeDescription)
				.append(nameTypeCode, castOther.nameTypeCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nameTypeCd).append(nameTypeName).append(nameTypeDescription).append(
				nameTypeCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("nameTypeCd", nameTypeCd).append("nameTypeName", nameTypeName).append(
				"nameTypeDescription", nameTypeDescription).append("nameTypeCode", nameTypeCode).toString();
	}
}