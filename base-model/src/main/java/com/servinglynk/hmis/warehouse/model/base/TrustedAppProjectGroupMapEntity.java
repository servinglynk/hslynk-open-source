package com.servinglynk.hmis.warehouse.model.base;

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
@Table(name = "hmis_trusted_app_project_group", schema = "base")
public class TrustedAppProjectGroupMapEntity extends BaseModel {

	@javax.persistence.Id
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "pg-uuid")
	@Column(name = "id")
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trustedapp_id", nullable = true)
	private TrustedAppEntity trustedApp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_group_id", nullable = true)
	private ProjectGroupEntity projectGroup;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public TrustedAppEntity getTrustedApp() {
		return trustedApp;
	}

	public void setTrustedApp(TrustedAppEntity trustedApp) {
		this.trustedApp = trustedApp;
	}

	public ProjectGroupEntity getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(ProjectGroupEntity projectGroup) {
		this.projectGroup = projectGroup;
	}
}