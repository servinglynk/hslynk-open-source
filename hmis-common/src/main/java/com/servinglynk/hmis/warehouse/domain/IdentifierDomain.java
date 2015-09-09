package com.servinglynk.hmis.warehouse.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * IdentifierDomain entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IdentifierDomain implements java.io.Serializable
{
	private static final long serialVersionUID = 2611151383140968220L;

	private Integer identifierDomainId;
	private User userCreatedBy;
	private String identifierDomainName;
	private String identifierDomainDescription;
	private String universalIdentifier;
	private String universalIdentifierTypeCode;
	private String namespaceIdentifier;
	private Date dateCreated;
	
	/** default constructor */
	public IdentifierDomain() {
	}

	/** minimal constructor */
	public IdentifierDomain(Integer identifierDomainId, User user, Date dateCreated) {
		this.identifierDomainId = identifierDomainId;
		this.userCreatedBy = user;
		this.dateCreated = dateCreated;
	}

	/** full constructor */
	public IdentifierDomain(Integer identifierDomainId, User user, String universalIdentifier,
			String universalIdentifierTypeCode, String namespaceIdentifier, Date dateCreated) {
		this.identifierDomainId = identifierDomainId;
		this.userCreatedBy = user;
		this.universalIdentifier = universalIdentifier;
		this.universalIdentifierTypeCode = universalIdentifierTypeCode;
		this.namespaceIdentifier = namespaceIdentifier;
		this.dateCreated = dateCreated;
	}

	// Property accessors
	@XmlElement
	public Integer getIdentifierDomainId() {
		return this.identifierDomainId;
	}

	public void setIdentifierDomainId(Integer identifierDomainId) {
		this.identifierDomainId = identifierDomainId;
	}

	public User getUserCreatedBy() {
		return this.userCreatedBy;
	}

	public void setUserCreatedBy(User user) {
		this.userCreatedBy = user;
	}

	@XmlElement
	public String getUniversalIdentifier() {
		return this.universalIdentifier;
	}

	public void setUniversalIdentifier(String universalIdentifier) {
		this.universalIdentifier = universalIdentifier;
	}

	@XmlElement
	public String getUniversalIdentifierTypeCode() {
		return this.universalIdentifierTypeCode;
	}

	public void setUniversalIdentifierTypeCode(String universalIdentifierTypeCode) {
		this.universalIdentifierTypeCode = universalIdentifierTypeCode;
	}

	@XmlElement
	public String getNamespaceIdentifier() {
		return this.namespaceIdentifier;
	}

	public void setNamespaceIdentifier(String namespaceIdentifier) {
		this.namespaceIdentifier = namespaceIdentifier;
	}

	@XmlElement
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@XmlElement
	public String getIdentifierDomainName() {
		return this.identifierDomainName;
	}

	public void setIdentifierDomainName(String identifierDomainName) {
		this.identifierDomainName = identifierDomainName;
	}

	@XmlElement
	public String getIdentifierDomainDescription() {
		return this.identifierDomainDescription;
	}

	public void setIdentifierDomainDescription(String identifierDomainDescription) {
		this.identifierDomainDescription = identifierDomainDescription;
	}

	@Override
	public boolean equals(final Object other) {
		if (this==other) {
			return true;
		}
		if (identifierDomainId == null) {
			return false;
		}
		if (!(other instanceof IdentifierDomain)) {
			return false;
		}
		IdentifierDomain castOther = (IdentifierDomain) other;
		if (this.identifierDomainId == castOther.getIdentifierDomainId()) {
			return true;
		}
		if (this.getNamespaceIdentifier() != null && castOther.getNamespaceIdentifier() != null) {
			return getNamespaceIdentifier().equals(castOther.getNamespaceIdentifier());
		}
		if (this.getUniversalIdentifier() != null && castOther.getUniversalIdentifier() != null &&
				this.getUniversalIdentifierTypeCode() != null && castOther.getUniversalIdentifierTypeCode() != null) {
			return new EqualsBuilder().append(universalIdentifier, castOther.universalIdentifier).append(
							universalIdentifierTypeCode, castOther.universalIdentifierTypeCode).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (identifierDomainId != null) {
			return new HashCodeBuilder().append(identifierDomainId).toHashCode(); 
		}
		if (this.getNamespaceIdentifier() != null ) {
			return new HashCodeBuilder().append(namespaceIdentifier).toHashCode();
		}
		if (this.getUniversalIdentifier() != null &&
				this.getUniversalIdentifierTypeCode() != null) {
			return new HashCodeBuilder().append(universalIdentifier)
			.append(universalIdentifierTypeCode).toHashCode();
		}
		return System.identityHashCode(this);
	}

	@Override
	public String toString() {
		return  "IdentifierDomain [identifierDomainId=" + identifierDomainId 
							  + ", identifierDomainName=" + identifierDomainName
							  + ", identifierDomainDescription=" + identifierDomainDescription
							  + ", universalIdentifier=" + universalIdentifier
							  + ", universalIdentifierTypeCode=" + universalIdentifierTypeCode
							  + ", namespaceIdentifier=" + namespaceIdentifier
							  + "]";
	}

	public Integer hydrate() {
		return getIdentifierDomainId();
	}

}