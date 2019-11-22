package com.servinglynk.hmis.warehouse.model.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hmis_project_sub_group",schema="base")
public class ProjectSubGroupEntity extends HMISModel {

	private java.util.UUID id;
	private String projectSubGroupName;
	private Boolean userDefined;
	

	private List<ProjectSubGroupProjectMapEntity> projectMaps = new ArrayList<ProjectSubGroupProjectMapEntity>();
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return id;
	}
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	@Column(name="project_subgroup_name")
	public String getProjectSubGroupName() {
		return projectSubGroupName;
	}
	public void setProjectSubGroupName(String projectSubGroupName) {
		this.projectSubGroupName = projectSubGroupName;
	}
	
	@Column(name="user_defined")
	public Boolean getUserDefined() {
		return userDefined;
	}
	public void setUserDefined(Boolean userDefined) {
		this.userDefined = userDefined;
	}
	
	@OneToMany(mappedBy = "projectSubGroup")
	public List<ProjectSubGroupProjectMapEntity> getProjectMaps() {
		return projectMaps;
	}
	public void setProjectMaps(List<ProjectSubGroupProjectMapEntity> projectMaps) {
		this.projectMaps = projectMaps;
	}
}