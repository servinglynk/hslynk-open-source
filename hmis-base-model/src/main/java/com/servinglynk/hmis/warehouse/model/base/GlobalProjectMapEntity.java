package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hmis_global_project_map",schema="base")
public class GlobalProjectMapEntity extends HMISModel {
	
	private UUID id;
	private UUID projectId;
	private String source;
	private GlobalProjectEntity globalProject;
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	

	@Column( name = "project_id") @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getProjectId() {
		return projectId;
	}
	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}
	

	@Column( name = "source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "global_project_id", referencedColumnName="id")
	public GlobalProjectEntity getGlobalProject() {
		return globalProject;
	}
	public void setGlobalProject(GlobalProjectEntity globalProject) {
		this.globalProject = globalProject;
	}
}