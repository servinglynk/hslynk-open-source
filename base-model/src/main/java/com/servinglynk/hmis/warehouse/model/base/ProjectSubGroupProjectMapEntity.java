package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hmis_project_subgroup_projects",schema="base")
public class ProjectSubGroupProjectMapEntity extends HMISModel{

	private UUID id;
	private Project projectId;
	private ProjectSubGroupEntity projectSubGroup;
	
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
	public Project getProjectId() {
		return projectId;
	}
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}
	
	@ManyToOne
	@JoinColumn(name = "project_subgroup_id", referencedColumnName="id")
	public ProjectSubGroupEntity getProjectSubGroup() {
		return projectSubGroup;
	}
	public void setProjectSubGroup(ProjectSubGroupEntity projectSubGroup) {
		this.projectSubGroup = projectSubGroup;
	}	
}