package com.servinglynk.hmis.household.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class GlobalHouseholdBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="date_created")
	@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
	private LocalDateTime dateCreated;
	
	@Column(name="date_updated")
	@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
	private LocalDateTime dateUpdated;
	
	@Column(name="user_create")
	private String userCreate;
	
	@Column(name="user_update")
	private String userUpdate;
	
	@Column(name="inactive")
	private Boolean inactive;
	

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
	
	
	public Boolean getInactive() {
		return inactive;
	}
	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((inactive == null) ? 0 : inactive.hashCode());
		result = prime * result + ((userUpdate == null) ? 0 : userUpdate.hashCode());
		result = prime * result + ((userCreate == null) ? 0 : userCreate.hashCode());
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
		GlobalHouseholdBaseEntity other = (GlobalHouseholdBaseEntity) obj;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (inactive == null) {
			if (other.inactive != null)
				return false;
		} else if (!inactive.equals(other.inactive))
			return false;
		if (userUpdate == null) {
			if (other.userUpdate != null)
				return false;
		} else if (!userUpdate.equals(other.userUpdate))
			return false;
		if (userCreate == null) {
			if (other.userCreate != null)
				return false;
		} else if (!userCreate.equals(other.userCreate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GlobalHouseholdBaseEntity [dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated
				+ ", userCreate=" + userCreate + ", userUpdate=" + userUpdate + ", inactive=" + inactive + "]";
	}
	
	
}
