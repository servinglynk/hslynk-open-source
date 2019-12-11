package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hmis_project_user",schema="base")
public class ProjectUserEntity extends HMISModel {

	private UUID id;
	private Project project;
	private HmisUser projectUser;
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName="id")
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	@ManyToOne
	@JoinColumn(name = "project_user_id", referencedColumnName="id")
	public HmisUser getProjectUser() {
		return projectUser;
	}
	public void setProjectUser(HmisUser projectUser) {
		this.projectUser = projectUser;
	}
}