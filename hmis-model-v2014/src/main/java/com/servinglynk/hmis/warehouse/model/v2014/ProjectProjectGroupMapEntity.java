package com.servinglynk.hmis.warehouse.model.v2014;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;


@Entity
@Table(name="hmis_project_projectgroup_map")
public class ProjectProjectGroupMapEntity {

	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id",nullable=false,referencedColumnName="id")
	private Project project ;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "project_group_id", nullable = false )
	private ProjectGroupEntity projectGroupEntity;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public ProjectGroupEntity getProjectGroupEntity() {
		return projectGroupEntity;
	}
	public void setProjectGroupEntity(ProjectGroupEntity projectGroupEntity) {
		this.projectGroupEntity = projectGroupEntity;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}	
	
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Column(name = "insert_at")	
	protected LocalDateTime insertAt ;

	@Column(name = "INSERT_BY")	
	protected String insertBy;

	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Column(name = "UPDATE_AT")	
	protected LocalDateTime updateAt;
	
	@Column(name = "UPDATE_BY")	
	protected String updateBy;

	

	public LocalDateTime getInsertAt() {
		return insertAt;
	}

	public void setInsertAt(LocalDateTime insertAt) {
		this.insertAt = insertAt;
	}


	public String getInsertBy() {
		return insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}


	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}


	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}