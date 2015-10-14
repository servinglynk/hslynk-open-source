package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * IdentifierDomainAttribute entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IdentifierDomainAttribute implements Serializable
{
	private static final long serialVersionUID = 2611151383140968220L;

	private Integer identifierDomainAttributeId;
	private Integer identifierDomainId;
	private String attributeName;
	private String attributeValue;
	
	/** default constructor */
	public IdentifierDomainAttribute() {
	}

	/** minimal constructor */
	public IdentifierDomainAttribute(Integer identifierDomainAttributeId, Integer identifierDomainId) {
		this.identifierDomainAttributeId = identifierDomainAttributeId;
		this.identifierDomainId = identifierDomainId;
	}

	/** full constructor */
	public IdentifierDomainAttribute(Integer identifierDomainId, String attributeName, String attributeValue) {
		this.identifierDomainId = identifierDomainId;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	// Property accessors
	@XmlElement
	public Integer getIdentifierDomainAttributeId() {
		return identifierDomainAttributeId;
	}

	public void setIdentifierDomainAttributeId(Integer identifierDomainAttributeId) {
		this.identifierDomainAttributeId = identifierDomainAttributeId;
	}

	@XmlElement
	public Integer getIdentifierDomainId() {
		return identifierDomainId;
	}

	public void setIdentifierDomainId(Integer identifierDomainId) {
		this.identifierDomainId = identifierDomainId;
	}

	@XmlElement
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@XmlElement
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof IdentifierDomainAttribute))
			return false;
		IdentifierDomainAttribute castOther = (IdentifierDomainAttribute) other;
		return new EqualsBuilder().append(identifierDomainAttributeId,
				castOther.identifierDomainAttributeId).append(
				identifierDomainId, castOther.identifierDomainId).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(identifierDomainAttributeId)
				.append(identifierDomainId).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("identifierDomainAttributeId",
				identifierDomainAttributeId).append("identifierDomainId",
				identifierDomainId).append("attributeName", attributeName)
				.append("attributeValue", attributeValue).toString();
	}	
}
