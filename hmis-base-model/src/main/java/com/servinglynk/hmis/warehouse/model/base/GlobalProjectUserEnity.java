package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hmis_global_project_user",schema="base")
public class GlobalProjectUserEnity extends HMISModel {
	
	private UUID id;
	private GlobalProjectEntity globalProject;
	private HmisUser hmisUser;
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "global_project_id", referencedColumnName="id")
	public GlobalProjectEntity getGlobalProject() {
		return globalProject;
	}
	public void setGlobalProject(GlobalProjectEntity globalProject) {
		this.globalProject = globalProject;
	}

	@ManyToOne
	@JoinColumn(name = "global_project_user_id", referencedColumnName="id")
	public HmisUser getHmisUser() {
		return hmisUser;
	}
	public void setHmisUser(HmisUser hmisUser) {
		this.hmisUser = hmisUser;
	}
}