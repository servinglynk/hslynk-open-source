package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Exitrhy  extends BaseModel{

	@Column( name = "assistance_main_stream_benefits")
	private Integer assistanceMainStreamBenefits;
	
	@Column( name = "early_exit_reason")
	private Integer earlyExitReason;
	
	@Column(name = "exitid")
	private Exit exitid;
	
	@Column( name = "exit_counseling")
	private Integer exitCounseling;
	
	@Column( name = "family_reunification_achieved")
	private Integer familyReunificationAchieved;
	
	@Column( name = "further_followup_services")
	private Integer furtherFollowupServices;
	
	@Column( name = "id")
	private java.util.UUID id;
	
	@Column( name = "other_aftercare_plan_or_action")
	private Integer otherAftercarePlanOrAction;
	
	@Column( name = "permenant_housing_placement")
	private Integer permenantHousingPlacement;
	
	@Column( name = "project_completion_status")
	private Integer projectCompletionStatus;
	
	@Column( name = "resource_package")
	private Integer resourcePackage;
	
	@Column( name = "scheduled_followup_contacts")
	private Integer scheduledFollowupContacts;
	
	@Column( name = "temp_shelter_placement")
	private Integer tempShelterPlacement;
	
	@Column( name = "written_after_care_plan")
	private Integer writtenAfterCarePlan;

	public Integer getAssistanceMainStreamBenefits() {
		return assistanceMainStreamBenefits;
	}

	public void setAssistanceMainStreamBenefits(Integer assistanceMainStreamBenefits) {
		this.assistanceMainStreamBenefits = assistanceMainStreamBenefits;
	}

	public Integer getEarlyExitReason() {
		return earlyExitReason;
	}

	public void setEarlyExitReason(Integer earlyExitReason) {
		this.earlyExitReason = earlyExitReason;
	}

	public Exit getExitid() {
		return exitid;
	}

	public void setExitid(Exit exitid) {
		this.exitid = exitid;
	}

	public Integer getExitCounseling() {
		return exitCounseling;
	}

	public void setExitCounseling(Integer exitCounseling) {
		this.exitCounseling = exitCounseling;
	}

	public Integer getFamilyReunificationAchieved() {
		return familyReunificationAchieved;
	}

	public void setFamilyReunificationAchieved(Integer familyReunificationAchieved) {
		this.familyReunificationAchieved = familyReunificationAchieved;
	}

	public Integer getFurtherFollowupServices() {
		return furtherFollowupServices;
	}

	public void setFurtherFollowupServices(Integer furtherFollowupServices) {
		this.furtherFollowupServices = furtherFollowupServices;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public Integer getOtherAftercarePlanOrAction() {
		return otherAftercarePlanOrAction;
	}

	public void setOtherAftercarePlanOrAction(Integer otherAftercarePlanOrAction) {
		this.otherAftercarePlanOrAction = otherAftercarePlanOrAction;
	}

	public Integer getPermenantHousingPlacement() {
		return permenantHousingPlacement;
	}

	public void setPermenantHousingPlacement(Integer permenantHousingPlacement) {
		this.permenantHousingPlacement = permenantHousingPlacement;
	}

	public Integer getProjectCompletionStatus() {
		return projectCompletionStatus;
	}

	public void setProjectCompletionStatus(Integer projectCompletionStatus) {
		this.projectCompletionStatus = projectCompletionStatus;
	}

	public Integer getResourcePackage() {
		return resourcePackage;
	}

	public void setResourcePackage(Integer resourcePackage) {
		this.resourcePackage = resourcePackage;
	}

	public Integer getScheduledFollowupContacts() {
		return scheduledFollowupContacts;
	}

	public void setScheduledFollowupContacts(Integer scheduledFollowupContacts) {
		this.scheduledFollowupContacts = scheduledFollowupContacts;
	}

	public Integer getTempShelterPlacement() {
		return tempShelterPlacement;
	}

	public void setTempShelterPlacement(Integer tempShelterPlacement) {
		this.tempShelterPlacement = tempShelterPlacement;
	}

	public Integer getWrittenAfterCarePlan() {
		return writtenAfterCarePlan;
	}

	public void setWrittenAfterCarePlan(Integer writtenAfterCarePlan) {
		this.writtenAfterCarePlan = writtenAfterCarePlan;
	}
	
	
}
