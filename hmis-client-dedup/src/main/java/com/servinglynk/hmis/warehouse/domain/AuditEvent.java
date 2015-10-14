package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * AuditEvent entity.
 * 
 */
public class AuditEvent extends BaseObject implements Serializable
{
	private static final long serialVersionUID = -6061320465621019356L;

	private Integer auditEventId;
	private Date dateCreated;
	private AuditEventType auditEventType;
	private String auditEventDescription;
	private Person refPerson;
	private Person altRefPerson;
	private User userCreatedBy;

	/** default constructor */
	public AuditEvent() {
	}

	public AuditEvent(Date dateCreated, AuditEventType auditEventType, String auditEventDescription, User userCreatedBy) {
		super();
		this.dateCreated = dateCreated;
		this.auditEventType = auditEventType;
		this.auditEventDescription = auditEventDescription;
		this.userCreatedBy = userCreatedBy;
	}

	public Integer getAuditEventId() {
		return auditEventId;
	}

	public void setAuditEventId(Integer auditEventId) {
		this.auditEventId = auditEventId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public AuditEventType getAuditEventType() {
		return auditEventType;
	}

	public void setAuditEventType(AuditEventType auditEventType) {
		this.auditEventType = auditEventType;
	}

	public String getAuditEventDescription() {
		return auditEventDescription;
	}

	public void setAuditEventDescription(String auditEventDescription) {
		this.auditEventDescription = auditEventDescription;
	}

	public Person getRefPerson() {
		return refPerson;
	}

	public void setRefPerson(Person refPerson) {
		this.refPerson = refPerson;
	}

	public Person getAltRefPerson() {
		return altRefPerson;
	}

	public void setAltRefPerson(Person altRefPerson) {
		this.altRefPerson = altRefPerson;
	}

	public User getUserCreatedBy() {
		return userCreatedBy;
	}

	public void setUserCreatedBy(User userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AuditEvent))
			return false;
		AuditEvent castOther = (AuditEvent) other;
		return new EqualsBuilder().append(auditEventId, castOther.auditEventId)
				.append(dateCreated, castOther.dateCreated).append(
						auditEventType, castOther.auditEventType).append(
						auditEventDescription, castOther.auditEventDescription)
				.append(refPerson, castOther.refPerson).append(altRefPerson,
						castOther.altRefPerson).append(userCreatedBy,
						castOther.userCreatedBy).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(auditEventId).append(dateCreated)
				.append(auditEventType).append(auditEventDescription).append(
						refPerson).append(altRefPerson).append(userCreatedBy)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("auditEventId", auditEventId)
				.append("dateCreated", dateCreated).append("auditEventType",
						auditEventType).append("auditEventDescription",
						auditEventDescription).append("refPerson", refPerson)
				.append("altRefPerson", altRefPerson).append("userCreatedBy",
						userCreatedBy).toString();
	}

}
