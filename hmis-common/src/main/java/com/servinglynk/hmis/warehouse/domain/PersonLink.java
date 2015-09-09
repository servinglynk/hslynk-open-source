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
 * PersonLink entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class PersonLink extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -2998399249175445866L;

	private Integer personLinkId;
	private Person personLeft;
	private Person personRight;
	private User userCreatedBy;
	private Date dateCreated;
	private Double weight;
	private LinkSource linkSource;
	private Integer clusterId;

	/** default constructor */
	public PersonLink() {
	}

	/** full constructor */
	public PersonLink(Integer personLinkId, Person personByLhPersonId, Person personByRhPersonId, User userCreatedBy,
			Date dateCreated) {
		this.personLinkId = personLinkId;
		this.personLeft = personByLhPersonId;
		this.personRight = personByRhPersonId;
		this.userCreatedBy = userCreatedBy;
		this.dateCreated = dateCreated;
	}

	// Property accessors
	@XmlElement
	public Integer getPersonLinkId() {
		return this.personLinkId;
	}

	public void setPersonLinkId(Integer personLinkId) {
		this.personLinkId = personLinkId;
	}

	@XmlElement
	public Person getPersonLeft() {
		return this.personLeft;
	}

	public void setPersonLeft(Person person) {
		this.personLeft = person;
	}

	@XmlElement
	public Person getPersonRight() {
		return this.personRight;
	}

	public void setPersonRight(Person person) {
		this.personRight = person;
	}

	@XmlElement
	public User getUserCreatedBy() {
		return this.userCreatedBy;
	}

	public void setUserCreatedBy(User userByCreatorId) {
		this.userCreatedBy = userByCreatorId;
	}

	@XmlElement
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@XmlElement
	public Double getWeight() {
		return this.weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	@XmlElement
	public LinkSource getLinkSource() {
		return linkSource;
	}

	public void setLinkSource(LinkSource linkSource) {
		this.linkSource = linkSource;
	}

		@XmlElement
	public Integer getClusterId() {
		return clusterId;
	}

	public void setClusterId(Integer clusterId) {
		this.clusterId = clusterId;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PersonLink))
			return false;
		PersonLink castOther = (PersonLink) other;
		return new EqualsBuilder().append(personLinkId, castOther.personLinkId).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(personLinkId).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("personLinkId", personLinkId)
			.append("personLeft",personLeft.getPersonId()).append("personRight", personRight.getPersonId())
			.append("creatorId", userCreatedBy).append("dateCreated", dateCreated).append("weight", weight)
			.append("linkSource", linkSource).append("clusterId", clusterId).toString();
	}
}