package com.servinglynk.hmis.warehouse.model.v2016;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


@Entity
public class Exitrhy  extends BaseModel{

	@Column( name = "assistance_main_stream_benefits")
	private Integer assistance_main_stream_benefits;
	
	@Column( name = "early_exit_reason")
	private Integer early_exit_reason;
	
	@Column(name = "exitid")
	private Exit exitid;
	
	@Column( name = "exit_counseling")
	private Integer exit_counseling;
	
	@Column( name = "family_reunification_achieved")
	private Integer family_reunification_achieved;
	
	@Column( name = "further_followup_services")
	private Integer further_followup_services;
	
	@Column( name = "id")
	private java.util.UUID id;
	
	@Column( name = "other_aftercare_plan_or_action")
	private Integer other_aftercare_plan_or_action;
	
	@Column( name = "permenant_housing_placement")
	private Integer permenant_housing_placement;
	
	@Column( name = "project_completion_status")
	private Integer project_completion_status;
	
	@Column( name = "resource_package")
	private Integer resource_package;
	
	@Column( name = "scheduled_followup_contacts")
	private Integer scheduled_followup_contacts;
	
	@Column( name = "temp_shelter_placement")
	private Integer temp_shelter_placement;
	
	@Column( name = "written_after_care_plan")
	private Integer written_after_care_plan;

	public Integer getAssistance_main_stream_benefits() {
		return assistance_main_stream_benefits;
	}

	public void setAssistance_main_stream_benefits(
			Integer assistance_main_stream_benefits) {
		this.assistance_main_stream_benefits = assistance_main_stream_benefits;
	}

	public Integer getEarly_exit_reason() {
		return early_exit_reason;
	}

	public void setEarly_exit_reason(Integer early_exit_reason) {
		this.early_exit_reason = early_exit_reason;
	}

	public Exit getExitid() {
		return exitid;
	}

	public void setExitid(Exit exitid) {
		this.exitid = exitid;
	}

	public Integer getExit_counseling() {
		return exit_counseling;
	}

	public void setExit_counseling(Integer exit_counseling) {
		this.exit_counseling = exit_counseling;
	}

	public Integer getFamily_reunification_achieved() {
		return family_reunification_achieved;
	}

	public void setFamily_reunification_achieved(
			Integer family_reunification_achieved) {
		this.family_reunification_achieved = family_reunification_achieved;
	}

	public Integer getFurther_followup_services() {
		return further_followup_services;
	}

	public void setFurther_followup_services(Integer further_followup_services) {
		this.further_followup_services = further_followup_services;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public Integer getOther_aftercare_plan_or_action() {
		return other_aftercare_plan_or_action;
	}

	public void setOther_aftercare_plan_or_action(
			Integer other_aftercare_plan_or_action) {
		this.other_aftercare_plan_or_action = other_aftercare_plan_or_action;
	}

	public Integer getPermenant_housing_placement() {
		return permenant_housing_placement;
	}

	public void setPermenant_housing_placement(Integer permenant_housing_placement) {
		this.permenant_housing_placement = permenant_housing_placement;
	}

	public Integer getProject_completion_status() {
		return project_completion_status;
	}

	public void setProject_completion_status(Integer project_completion_status) {
		this.project_completion_status = project_completion_status;
	}

	public Integer getResource_package() {
		return resource_package;
	}

	public void setResource_package(Integer resource_package) {
		this.resource_package = resource_package;
	}

	public Integer getScheduled_followup_contacts() {
		return scheduled_followup_contacts;
	}

	public void setScheduled_followup_contacts(Integer scheduled_followup_contacts) {
		this.scheduled_followup_contacts = scheduled_followup_contacts;
	}

	public Integer getTemp_shelter_placement() {
		return temp_shelter_placement;
	}

	public void setTemp_shelter_placement(Integer temp_shelter_placement) {
		this.temp_shelter_placement = temp_shelter_placement;
	}

	public Integer getWritten_after_care_plan() {
		return written_after_care_plan;
	}

	public void setWritten_after_care_plan(Integer written_after_care_plan) {
		this.written_after_care_plan = written_after_care_plan;
	}
	
	
		
	
}
