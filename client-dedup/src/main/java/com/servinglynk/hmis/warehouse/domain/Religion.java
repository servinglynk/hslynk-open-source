package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Religion entity.
 * 
 */
public class Religion extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -8484009651057411655L;

	private Integer religionCd;
	private String religionName;
	private String religionDescription;
	private String religionCode;
	
	/** default constructor */
	public Religion() {
	}

	/** minimal constructor */
	public Religion(Integer religionCd, String religionName) {
		this.religionCd = religionCd;
		this.religionName = religionName;
	}

	/** full constructor */
	public Religion(Integer religionCd, String religionName, String religionDescription) {
		this.religionCd = religionCd;
		this.religionName = religionName;
		this.religionDescription = religionDescription;
	}

	public Integer getReligionCd() {
		return this.religionCd;
	}

	public void setReligionCd(Integer religionCd) {
		this.religionCd = religionCd;
	}

	public String getReligionName() {
		return this.religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

	public String getReligionDescription() {
		return this.religionDescription;
	}

	public void setReligionDescription(String religionDescription) {
		this.religionDescription = religionDescription;
	}

	public String getReligionCode() {
		return religionCode;
	}

	public void setReligionCode(String religionCode) {
		this.religionCode = religionCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Religion))
			return false;
		Religion castOther = (Religion) other;
		return new EqualsBuilder().append(religionCd, castOther.religionCd)
				.append(religionName, castOther.religionName)
				.append(religionDescription, castOther.religionDescription)
				.append(religionCode, castOther.religionCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(religionCd).append(religionName).append(religionDescription).append(
				religionCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("religionCd", religionCd).append("religionName", religionName).append(
				"religionDescription", religionDescription).append("religionCode", religionCode).toString();
	}

}