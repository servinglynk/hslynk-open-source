package com.servinglynk.hmis.warehouse.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Gender entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Gender extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 2361596403749617326L;

	private Integer genderCd;
	private String genderName;
	private String genderDescription;
	private String genderCode;
	
	/** default constructor */
	public Gender() {
	}

	/** minimal constructor */
	public Gender(Integer genderCd, String genderName) {
		this.genderCd = genderCd;
		this.genderName = genderName;
	}

	/** full constructor */
	public Gender(Integer genderCd, String genderName, String genderDescription) {
		this.genderCd = genderCd;
		this.genderName = genderName;
		this.genderDescription = genderDescription;
	}

	@XmlElement
	public Integer getGenderCd() {
		return this.genderCd;
	}

	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}

	@XmlElement
	public String getGenderName() {
		return this.genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	@XmlElement
	public String getGenderDescription() {
		return this.genderDescription;
	}

	public void setGenderDescription(String genderDescription) {
		this.genderDescription = genderDescription;
	}

	@XmlElement
	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Gender))
			return false;
		Gender castOther = (Gender) other;
		return new EqualsBuilder().append(genderCd, castOther.genderCd).append(genderName, castOther.genderName)
				.append(genderDescription, castOther.genderDescription).append(genderCode, castOther.genderCode)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(genderCd).append(genderName).append(genderDescription).append(genderCode)
				.toHashCode();
	}

	@Override
	public String toString() {
		return (genderName == null) ? "null" : genderName;
//		return new ToStringBuilder(this).append("genderCd", genderCd).append("genderName", genderName).append(
//				"genderDescription", genderDescription).append("genderCode", genderCode).toString();
	}

}