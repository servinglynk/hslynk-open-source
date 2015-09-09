package com.servinglynk.hmis.warehouse.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_profile")
public class ProfileEntity extends BaseModel{
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	protected UUID id;
    
	@Column(name="profile_name")
	protected String profileName;
	
	@Column(name="profile_description")
	protected String profileDescription;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="profileEntity")
	List<ProfileACLEntity> profileACLEntities= new ArrayList<ProfileACLEntity>(); 

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}



	public List<ProfileACLEntity> getProfileACLEntities() {
		return profileACLEntities;
	}

	public void setProfileACLEntities(List<ProfileACLEntity> profileACLEntities) {
		this.profileACLEntities = profileACLEntities;
	}
	


}
