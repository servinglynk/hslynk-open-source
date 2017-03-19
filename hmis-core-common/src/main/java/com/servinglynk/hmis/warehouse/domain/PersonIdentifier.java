package com.servinglynk.hmis.warehouse.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * PersonIdentifier entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class PersonIdentifier extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;

	private Integer personIdentifierId;
	private IdentifierDomain identifierDomain;
	private User userCreatedBy;
	private User userVoidedBy;
	private Person person;
	private String identifier;
	private Date dateCreated;
	private Date dateVoided;

	/** default constructor */
	public PersonIdentifier() {
	}

	/** minimal constructor */
	public PersonIdentifier(Integer personIdentifierId, IdentifierDomain identifierDomain, User userByCreatorId,
			Person person, String identifier, Date dateCreated) {
		this.personIdentifierId = personIdentifierId;
		this.identifierDomain = identifierDomain;
		this.userCreatedBy = userByCreatorId;
		this.person = person;
		this.identifier = identifier;
		this.dateCreated = dateCreated;
	}

	/** full constructor */
	public PersonIdentifier(Integer personIdentifierId, IdentifierDomain identifierDomain, User userByCreatorId,
			User userByVoidedById, Person person, String identifier, Date dateCreated, Date dateVoided) {
		this.personIdentifierId = personIdentifierId;
		this.identifierDomain = identifierDomain;
		this.userCreatedBy = userByCreatorId;
		this.userVoidedBy = userByVoidedById;
		this.person = person;
		this.identifier = identifier;
		this.dateCreated = dateCreated;
		this.dateVoided = dateVoided;
	}

	// Property accessors
	@XmlElement
	public Integer getPersonIdentifierId() {
		return this.personIdentifierId;
	}

	public void setPersonIdentifierId(Integer personIdentifierId) {
		this.personIdentifierId = personIdentifierId;
	}

	@XmlElement
	public IdentifierDomain getIdentifierDomain() {
		return this.identifierDomain;
	}

	public void setIdentifierDomain(IdentifierDomain identifierDomain) {
		this.identifierDomain = identifierDomain;
	}

	public User getUserCreatedBy() {
		return this.userCreatedBy;
	}

	public void setUserCreatedBy(User userByCreatorId) {
		this.userCreatedBy = userByCreatorId;
	}

	public User getUserVoidedBy() {
		return this.userVoidedBy;
	}

	public void setUserVoidedBy(User userByVoidedById) {
		this.userVoidedBy = userByVoidedById;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlElement
	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@XmlElement
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@XmlElement
	public Date getDateVoided() {
		return this.dateVoided;
	}

	public void setDateVoided(Date dateVoided) {
		this.dateVoided = dateVoided;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PersonIdentifier))
			return false;
		PersonIdentifier castOther = (PersonIdentifier) other;
		if (other == this) {
			return true;
		}
		if (personIdentifierId == castOther.personIdentifierId) {
			return true;
		}
		return new EqualsBuilder().append(identifierDomain,
				castOther.identifierDomain)
				.append(identifier, castOther.identifier)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(personIdentifierId)
			.append(identifierDomain)
			.append(identifier).toHashCode();
	}
/*
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("personIdentifierId", personIdentifierId).append("identifierDomain",
				identifierDomain).append("userByCreatorId", userCreatedBy).append("userByVoidedById",
				userVoidedBy).append("identifier", identifier).append("dateCreated",
				dateCreated).append("dateVoided", dateVoided).toString();
	}
	*/
	@Override
	public String toString() {
		if (identifierDomain != null) {
			return new ToStringBuilder(this)
				.append("personIdentifierId", personIdentifierId)
				.append("identifierDomainId", identifierDomain.getIdentifierDomainId())
				.append("identifier", identifier)
				.append("dateVoided", dateVoided).toString();
		} else {
			return new ToStringBuilder(this)
			.append("personIdentifierId", personIdentifierId)
			.append("identifierDomain", identifierDomain)
			.append("identifier", identifier)
			.append("dateVoided", dateVoided).toString();			
		}
	}

	public Integer hydrate() {
		return getPersonIdentifierId();
	}

}