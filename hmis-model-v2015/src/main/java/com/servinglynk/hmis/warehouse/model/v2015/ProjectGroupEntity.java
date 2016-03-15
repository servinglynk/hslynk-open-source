package com.servinglynk.hmis.warehouse.model.v2015;

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
@Entity (name = "hmis_project_group")
@Table(name = "hmis_project_group", catalog = "hmis", schema = "v2014")
public class ProjectGroupEntity  {


	private UUID id;
    

	private String projectGroupName;


    private String projectGroupDesc;
    

    private String projectGroupCode;
    
    private boolean skipuseridentifers;
    

    List<ProjectProjectGroupMapEntity> projectGroupMapEntities = new ArrayList<ProjectProjectGroupMapEntity>();
    
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
    @Column(name="project_group_name")
	public String getProjectGroupName() {
		return projectGroupName;
	}
	public void setProjectGroupName(String projectGroupName) {
		this.projectGroupName = projectGroupName;
	}
	
    @Column(name="project_group_desc")
	public String getProjectGroupDesc() {
		return projectGroupDesc;
	}
	public void setProjectGroupDesc(String projectGroupDesc) {
		this.projectGroupDesc = projectGroupDesc;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="projectGroupEntity")
	public List<ProjectProjectGroupMapEntity> getProjectGroupMapEntities() {
		return projectGroupMapEntities;
	}
	public void setProjectGroupMapEntities(List<ProjectProjectGroupMapEntity> projectGroupMapEntities) {
		this.projectGroupMapEntities = projectGroupMapEntities;
	}
	
    @Column(name="project_group_code")
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	@Column(name="skip_user_identifers")
	public boolean isSkipuseridentifers() {
		return skipuseridentifers;
	}
	public void setSkipuseridentifers(boolean skipuseridentifers) {
		this.skipuseridentifers = skipuseridentifers;
	}
	
}