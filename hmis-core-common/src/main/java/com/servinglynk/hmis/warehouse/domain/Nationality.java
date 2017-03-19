package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Nationality entity.
 * 
 */
public class Nationality extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 8807251669987078189L;

	private Integer nationalityCd;
	private String nationalityName;
	private String nationalityDescription;
	private String nationalityCode;
	
	/** default constructor */
	public Nationality() {
	}

	/** minimal constructor */
	public Nationality(Integer nationalityCd, String nationalityName) {
		this.nationalityCd = nationalityCd;
		this.nationalityName = nationalityName;
	}

	/** full constructor */
	public Nationality(Integer nationalityCd, String nationalityName, String nationalityDescriiption) {
		this.nationalityCd = nationalityCd;
		this.nationalityName = nationalityName;
		this.nationalityDescription = nationalityDescriiption;
	}

	public Integer getNationalityCd() {
		return this.nationalityCd;
	}

	public void setNationalityCd(Integer nationalityCd) {
		this.nationalityCd = nationalityCd;
	}

	public String getNationalityName() {
		return this.nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	public String getNationalityDescription() {
		return this.nationalityDescription;
	}

	public void setNationalityDescription(String nationalityDescription) {
		this.nationalityDescription = nationalityDescription;
	}

	public String getNationalityCode() {
		return nationalityCode;
	}

	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Nationality))
			return false;
		Nationality castOther = (Nationality) other;
		return new EqualsBuilder().append(nationalityCd, castOther.nationalityCd).append(nationalityName,
				castOther.nationalityName).append(nationalityDescription, castOther.nationalityDescription).append(
				nationalityCode, castOther.nationalityCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nationalityCd).append(nationalityName).append(nationalityDescription)
				.append(nationalityCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("nationalityCd", nationalityCd).append("nationalityName",
				nationalityName).append("nationalityDescription", nationalityDescription).append("nationalityCode",
				nationalityCode).toString();
	}

}