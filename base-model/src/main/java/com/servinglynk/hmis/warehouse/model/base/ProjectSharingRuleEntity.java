package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_sharing_rule",schema="base")
public class ProjectSharingRuleEntity extends HMISModel {

	private UUID id;
	private ProjectSubGroupEntity toProjectSubGroup;
	private ProjectSubGroupEntity projectSubGroup;
	private String toProjectGroupCode;
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "to_project_sub_group_id", referencedColumnName="id")
	public ProjectSubGroupEntity getToProjectSubGroup() {
		return toProjectSubGroup;
	}
	public void setToProjectSubGroup(ProjectSubGroupEntity toProjectSubGroup) {
		this.toProjectSubGroup = toProjectSubGroup;
	}
	
	@ManyToOne
	@JoinColumn(name = "project_sub_group_id", referencedColumnName="id")
	public ProjectSubGroupEntity getProjectSubGroup() {
		return projectSubGroup;
	}
	public void setProjectSubGroup(ProjectSubGroupEntity projectSubGroup) {
		this.projectSubGroup = projectSubGroup;
	}
	
	@Column(name="to_project_group_code")
	public String getToProjectGroupCode() {
		return toProjectGroupCode;
	}
	public void setToProjectGroupCode(String toProjectGroupCode) {
		this.toProjectGroupCode = toProjectGroupCode;
	}	
}