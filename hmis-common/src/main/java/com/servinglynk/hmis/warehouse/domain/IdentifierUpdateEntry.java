package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * IdentifierUpdateEnty entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IdentifierUpdateEntry extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	private Integer identifierUpdateEntryId;
	private IdentifierDomain identifierDomain;
	private String identifier;

	public IdentifierUpdateEntry() {
		
	}
	
	public IdentifierUpdateEntry(IdentifierDomain identifierDomain, String identifier) {
		this.identifierDomain = identifierDomain;
		this.identifier = identifier;
	}

	public Integer getIdentifierUpdateEntryId() {
		return identifierUpdateEntryId;
	}

	public void setIdentifierUpdateEntryId(Integer identifierUpdateEntryId) {
		this.identifierUpdateEntryId = identifierUpdateEntryId;
	}

	@XmlElement
	public IdentifierDomain getIdentifierDomain() {
		return identifierDomain;
	}

	public void setIdentifierDomain(IdentifierDomain identifierDomain) {
		this.identifierDomain = identifierDomain;
	}

	@XmlElement
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentifierUpdateEntry other = (IdentifierUpdateEntry) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (identifierDomain == null) {
			if (other.identifierDomain != null)
				return false;
		} else if (!identifierDomain.equals(other.identifierDomain))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((identifierDomain == null) ? 0 : identifierDomain.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "IdentifierUpdateEnty [identifierUpdateEntryId=" + identifierUpdateEntryId + ", identifierDomain="
				+ identifierDomain + ", identifier=" + identifier + "]";
	}
}
