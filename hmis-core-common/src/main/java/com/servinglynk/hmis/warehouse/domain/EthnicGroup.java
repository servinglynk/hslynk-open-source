package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * EthnicGroup entity.
 * 
 */
public class EthnicGroup extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 8162563656465936003L;

	private Integer ethnicGroupCd;
	private String ethnicGroupName;
	private String ethnicGroupDescription;
	private String ethnicGroupCode;

	/** default constructor */
	public EthnicGroup() {
	}

	/** minimal constructor */
	public EthnicGroup(Integer ethnicGroupCd, String ethnicGroupName) {
		this.ethnicGroupCd = ethnicGroupCd;
		this.ethnicGroupName = ethnicGroupName;
	}

	/** full constructor */
	public EthnicGroup(Integer ethnicGroupCd, String ethnicGroupName, String ethnicGroupDescription) {
		this.ethnicGroupCd = ethnicGroupCd;
		this.ethnicGroupName = ethnicGroupName;
		this.ethnicGroupDescription = ethnicGroupDescription;
	}

	public Integer getEthnicGroupCd() {
		return this.ethnicGroupCd;
	}

	public void setEthnicGroupCd(Integer ethnicGroupCd) {
		this.ethnicGroupCd = ethnicGroupCd;
	}

	public String getEthnicGroupName() {
		return this.ethnicGroupName;
	}

	public void setEthnicGroupName(String ethnicGroupName) {
		this.ethnicGroupName = ethnicGroupName;
	}

	public String getEthnicGroupDescription() {
		return this.ethnicGroupDescription;
	}

	public void setEthnicGroupDescription(String ethnicGroupDescription) {
		this.ethnicGroupDescription = ethnicGroupDescription;
	}

	public String getEthnicGroupCode() {
		return ethnicGroupCode;
	}

	public void setEthnicGroupCode(String ethnicGroupCode) {
		this.ethnicGroupCode = ethnicGroupCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof EthnicGroup))
			return false;
		EthnicGroup castOther = (EthnicGroup) other;
		return new EqualsBuilder().append(ethnicGroupCd, castOther.ethnicGroupCd).append(ethnicGroupName,
				castOther.ethnicGroupName).append(ethnicGroupDescription, castOther.ethnicGroupDescription).append(
				ethnicGroupCode, castOther.ethnicGroupCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(ethnicGroupCd).append(ethnicGroupName).append(ethnicGroupDescription)
				.append(ethnicGroupCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("ethnicGroupCd", ethnicGroupCd).append("ethnicGroupName",
				ethnicGroupName).append("ethnicGroupDescription", ethnicGroupDescription).append("ethnicGroupCode",
				ethnicGroupCode).toString();
	}

}