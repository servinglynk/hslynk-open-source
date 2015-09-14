package com.servinglynk.hmis.warehouse.model.live;

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
@Table(name="hmis_release_of_info")
public class ReleaseOfInfoEntity extends BaseModel {
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	public UUID id;
	
	@ManyToOne
	@JoinColumn(name = "enrollment_id", referencedColumnName="id")
	public Enrollment enrollment;
	
	@Column(name="is_consented")
	public boolean isConsented;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public boolean isConsented() {
		return isConsented;
	}
	public void setConsented(boolean isConsented) {
		this.isConsented = isConsented;
	}
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
}