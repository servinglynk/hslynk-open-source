package com.servinglynk.hmis.warehouse.model.live;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="hmis_sharing_rule")
public class SharingRuleEntity extends BaseModel {
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
    
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName="id")
	private RoleEntity role;
	
	@ManyToOne
	@JoinColumn(name = "from_organization_id", referencedColumnName="id")
	private Organization fromOrganization;
	
	@ManyToOne
	@JoinColumn(name = "to_organization_id", referencedColumnName="id")
	private Organization toOrganization;
	
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName="id")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "enrollment_id", referencedColumnName="id")
	private Enrollment enrollment;
	
	@Column(name = "active_from")
	private Date activeFrom;
	
	@Column(name = "active_to")
	private Date activeTo;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	public Organization getFromOrganization() {
		return fromOrganization;
	}
	public void setFromOrganization(Organization fromOrganization) {
		this.fromOrganization = fromOrganization;
	}
	public Organization getToOrganization() {
		return toOrganization;
	}
	public void setToOrganization(Organization toOrganization) {
		this.toOrganization = toOrganization;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}
	public Date getActiveTo() {
		return activeTo;
	}
	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}
}