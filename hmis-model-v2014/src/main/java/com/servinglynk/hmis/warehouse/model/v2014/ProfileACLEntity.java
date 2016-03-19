package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_profile_acl")
public class ProfileACLEntity extends BaseModel{
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	protected UUID id;
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "api_method_id", nullable=false, referencedColumnName="id")
	protected ApiMethodEntity apiMethodEntity;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profile_id",nullable=false,referencedColumnName="id")
	protected ProfileEntity profileEntity;


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public ApiMethodEntity getApiMethodEntity() {
		return apiMethodEntity;
	}


	public void setApiMethodEntity(ApiMethodEntity apiMethodEntity) {
		this.apiMethodEntity = apiMethodEntity;
	}


	public ProfileEntity getProfileEntity() {
		return profileEntity;
	}


	public void setProfileEntity(ProfileEntity profileEntity) {
		this.profileEntity = profileEntity;
	}
}
