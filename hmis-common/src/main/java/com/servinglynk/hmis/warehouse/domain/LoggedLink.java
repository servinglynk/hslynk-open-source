package com.servinglynk.hmis.warehouse.domain;

import java.util.Date;

/**
 * LoggedLink entity.
 * 
 */
public class LoggedLink extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -2998399249175445866L;

	private Integer linkId;
	private Long leftRecordId;
	private Long rightRecordId;
	private User userCreatedBy;
	private Date dateCreated;
	private Double weight;
	private Integer vectorValue;

	/** default constructor */
	public LoggedLink() {
	}

	// Property accessors
	public Integer getLinkId() {
		return this.linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public Long getLeftRecordId() {
		return this.leftRecordId;
	}

	public void setLeftRecordId(Long leftRecordId) {
		this.leftRecordId = leftRecordId;
	}

	public Long getRightRecordId() {
		return this.rightRecordId;
	}

	public void setRightRecordId(Long rightRecordId) {
		this.rightRecordId = rightRecordId;
	}

	public User getUserCreatedBy() {
		return this.userCreatedBy;
	}

	public void setUserCreatedBy(User userByCreatorId) {
		this.userCreatedBy = userByCreatorId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Double getWeight() {
		return this.weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Integer getVectorValue() {
		return vectorValue;
	}

	public void setVectorValue(Integer vectorValue) {
		this.vectorValue = vectorValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkId == null) ? 0 : linkId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoggedLink other = (LoggedLink) obj;
		if (linkId == null) {
			if (other.linkId != null)
				return false;
		} else if (!linkId.equals(other.linkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoggedLink [linkId=" + linkId + ", leftRecordId =" + leftRecordId + ", rightRecordId=" + rightRecordId
				+ ", userCreatedBy=" + userCreatedBy + ", dateCreated=" + dateCreated + ", weight=" + weight
				+ ", vectorValue=" + vectorValue + "]";
	}
}