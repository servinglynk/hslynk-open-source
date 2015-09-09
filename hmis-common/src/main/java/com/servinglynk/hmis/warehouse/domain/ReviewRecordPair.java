package com.servinglynk.hmis.warehouse.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PersonLink entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ReviewRecordPair extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -2998399249175445866L;

	private Integer reviewRecordPairId;
	private Person personLeft;
	private Person personRight;
	private User userCreatedBy;
	private Date dateCreated;
	private User userReviewedBy;
	private Date dateReviewed;
	private Double weight;
	private LinkSource linkSource;
	private Boolean recordsMatch;

	/** default constructor */
	public ReviewRecordPair() {
	}

	/** full constructor */
	public ReviewRecordPair(Integer reviewRecordPairId, Person personByLhPersonId, Person personByRhPersonId, User userCreatedBy,
			Date dateCreated) {
		this.reviewRecordPairId = reviewRecordPairId;
		this.personLeft = personByLhPersonId;
		this.personRight = personByRhPersonId;
		this.userCreatedBy = userCreatedBy;
		this.dateCreated = dateCreated;
	}

	// Property accessors
	@XmlElement
	public Integer getReviewRecordPairId() {
		return this.reviewRecordPairId;
	}

	public void setReviewRecordPairId(Integer reviewRecordPairId) {
		this.reviewRecordPairId = reviewRecordPairId;
	}	

	@XmlElement
	public User getUserReviewedBy() {
		return userReviewedBy;
	}

	public void setUserReviewedBy(User userReviewedBy) {
		this.userReviewedBy = userReviewedBy;
	}

	@XmlElement
	public Date getDateReviewed() {
		return dateReviewed;
	}

	public void setDateReviewed(Date dateReviewed) {
		this.dateReviewed = dateReviewed;
	}

	@XmlElement
	public Boolean getRecordsMatch() {
		return recordsMatch;
	}

	public void setRecordsMatch(Boolean recordsMatch) {
		this.recordsMatch = recordsMatch;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewRecordPair other = (ReviewRecordPair) obj;
		if (personLeft == null) {
			if (other.personLeft != null)
				return false;
		} else if (!personLeft.equals(other.personLeft))
			return false;
		if (personRight == null) {
			if (other.personRight != null)
				return false;
		} else if (!personRight.equals(other.personRight))
			return false;
		if (personLeft.getPersonId() == other.getPersonRight().getPersonId() ||
				personRight.getPersonId() == other.getPersonLeft().getPersonId())
			return true;
		if (reviewRecordPairId == null) {
			if (other.reviewRecordPairId != null)
				return false;
		} else if (!reviewRecordPairId.equals(other.reviewRecordPairId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personLeft == null) ? 0 : personLeft.hashCode());
		result = prime * result + ((personRight == null) ? 0 : personRight.hashCode());
		result = prime * result + ((reviewRecordPairId == null) ? 0 : reviewRecordPairId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ReviewRecordPair [reviewRecordPairId=" + reviewRecordPairId + ", personLeft=" + personLeft
				+ ", personRight=" + personRight + ", userCreatedBy=" + userCreatedBy + ", dateCreated=" + dateCreated
				+ ", userReviewedBy=" + userReviewedBy + ", dateReviewed=" + dateReviewed + ", weight=" + weight
				+ ", linkSource=" + linkSource + ", recordsMatch=" + recordsMatch + "]";
	}
}