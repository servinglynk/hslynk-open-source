package com.servinglynk.hmis.warehouse.model.live;

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
@Table(name="hmis_project_group")
public class ProjectGroupEntity {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
    
    @Column(name="project_group_name")
	private String projectGroupName;

    @Column(name="project_group_desc")
    private String projectGroupDesc;
    
	@OneToMany(fetch=FetchType.LAZY, mappedBy="projectGroupEntity")
    List<ProjectProjectGroupMapEntity> projectGroupMapEntities = new ArrayList<ProjectProjectGroupMapEntity>();
    
    
    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getProjectGroupName() {
		return projectGroupName;
	}
	public void setProjectGroupName(String projectGroupName) {
		this.projectGroupName = projectGroupName;
	}
	public String getProjectGroupDesc() {
		return projectGroupDesc;
	}
	public void setProjectGroupDesc(String projectGroupDesc) {
		this.projectGroupDesc = projectGroupDesc;
	}
	public List<ProjectProjectGroupMapEntity> getProjectGroupMapEntities() {
		return projectGroupMapEntities;
	}
	public void setProjectGroupMapEntities(List<ProjectProjectGroupMapEntity> projectGroupMapEntities) {
		this.projectGroupMapEntities = projectGroupMapEntities;
	}
	
	
}