package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * IdentifierUpdateEvent entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IdentifierUpdateEvent extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	public static final String ADD_SOURCE = "ADD";
	public static final String DELETE_SOURCE = "DELETE";
	public static final String UPDATE_SOURCE = "UPDATE";
	public static final String LINK_SOURCE = "LINK";
	public static final String UNLINK_SOURCE = "UNLINK";
	public static final String MERGE_SOURCE = "MERGE";

	public static final String JOIN_TRANSITION = "JOIN";
	public static final String LEAVE_TRANSITION = "LEAVE";
	
	private Long identifierUpdateEventId;
	private Date dateCreated;
	private User updateRecipient;
	private String source;
	private String transition;
	private Set<IdentifierUpdateEntry> preUpdateIdentifiers = new HashSet<IdentifierUpdateEntry>();
	private Set<IdentifierUpdateEntry> postUpdateIdentifiers = new HashSet<IdentifierUpdateEntry>();
	
	public IdentifierUpdateEvent() {
		this.dateCreated = new Date();
	}

	public IdentifierUpdateEvent(Set<IdentifierUpdateEntry> preUpdateIdentifiers, Set<IdentifierUpdateEntry> postUpdateIdentifiers, User updateRecipient) {
		this.dateCreated = new Date();
		this.preUpdateIdentifiers = preUpdateIdentifiers;
		this.postUpdateIdentifiers = postUpdateIdentifiers;
		this.updateRecipient = updateRecipient;
	}

	@XmlElement
	public Long getIdentifierUpdateEventId() {
		return identifierUpdateEventId;
	}

	public void setIdentifierUpdateEventId(Long identifierUpdateEventId) {
		this.identifierUpdateEventId = identifierUpdateEventId;
	}

	public User getUpdateRecipient() {
		return updateRecipient;
	}

	public void setUpdateRecipient(User updateRecipient) {
		this.updateRecipient = updateRecipient;
	}

	@XmlElement
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@XmlElement
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@XmlElement
	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	@XmlElementWrapper(name="preUpdateIdentifiers")
    @XmlElement(name="preUpdateIdentifier")
	public Set<IdentifierUpdateEntry> getPreUpdateIdentifiers() {
		return preUpdateIdentifiers;
	}

	public void setPreUpdateIdentifiers(Set<IdentifierUpdateEntry> preUpdateIdentifiers) {
		this.preUpdateIdentifiers = preUpdateIdentifiers;
	}

	@XmlElementWrapper(name="postUpdateIdentifiers")
    @XmlElement(name="postUpdateIdentifier")
	public Set<IdentifierUpdateEntry> getPostUpdateIdentifiers() {
		return postUpdateIdentifiers;
	}

	public void setPostUpdateIdentifiers(Set<IdentifierUpdateEntry> postUpdateIdentifiers) {
		this.postUpdateIdentifiers = postUpdateIdentifiers;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentifierUpdateEvent other = (IdentifierUpdateEvent) obj;
		if (identifierUpdateEventId == null) {
			if (other.identifierUpdateEventId != null)
				return false;
		} else if (!identifierUpdateEventId.equals(other.identifierUpdateEventId))
			return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifierUpdateEventId == null) ? 0 : identifierUpdateEventId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "IdentifierUpdateEvent [identifierUpdateEventId=" + identifierUpdateEventId + ", dateCreated="
				+ dateCreated + ", updateRecipient=" + updateRecipient + ", source=" + source +  ", transition=" + transition +
				", preUpdateIdentifiers=" + preUpdateIdentifiers + ", postUpdateIdentifiers=" + postUpdateIdentifiers + "]";
	}
}
