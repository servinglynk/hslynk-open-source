package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Language entity.
 * 
 */
public class Language extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -5571536094478016725L;

	private Integer languageCd;
	private String languageName;
	private String languageDescription;
	private String languageCode;
	
	/** default constructor */
	public Language() {
	}

	/** minimal constructor */
	public Language(Integer languageCd, String languageName) {
		this.languageCd = languageCd;
		this.languageName = languageName;
	}

	/** full constructor */
	public Language(Integer languageCd, String languageName, String languageDescription) {
		this.languageCd = languageCd;
		this.languageName = languageName;
		this.languageDescription = languageDescription;
	}

	public Integer getLanguageCd() {
		return this.languageCd;
	}

	public void setLanguageCd(Integer languageCd) {
		this.languageCd = languageCd;
	}

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageDescription() {
		return this.languageDescription;
	}

	public void setLanguageDescription(String languageDescription) {
		this.languageDescription = languageDescription;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Language))
			return false;
		Language castOther = (Language) other;
		return new EqualsBuilder().append(languageCd, castOther.languageCd)
				.append(languageName, castOther.languageName)
				.append(languageDescription, castOther.languageDescription)
				.append(languageCode, castOther.languageCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(languageCd).append(languageName).append(languageDescription).append(
				languageCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("languageCd", languageCd).append("languageName", languageName).append(
				"languageDescription", languageDescription).append("languageCode", languageCode).toString();
	}
}