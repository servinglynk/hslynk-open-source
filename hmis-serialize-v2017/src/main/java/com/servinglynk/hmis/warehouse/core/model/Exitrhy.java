package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitrhy")
public class Exitrhy extends ClientModel{


    private UUID exitrhyId;
  	private Integer earlyExitReason;
  	private UUID exitid;
  	private Integer projectCompletionStatus;
  	private Integer exchangeForSex;
  	private Integer exchangeForSexPastThreeMonths;
  	private Integer countOfExchangeForSex;  
  	private Integer askedOrForcedToExchangeForSex;
  	private Integer askedOrForcedToExchangeForSexPastThreeMonths; 
  	private Integer workPlaceViolenceThreats;  
  	private Integer workPlacePromiseDifference;
  	private Integer coercedToContinueWork;  
  	private Integer laborExploitPastThreeMonths;
  	private Integer counselingReceived; 
  	private Integer individualCounseling;  
  	private Integer familyCounseling;
  	private Integer groupCounseling;
  	private Integer sessionCountAtExit;
  	private Integer sessionsInPlan; 
  	private Integer postExitCounselingPlan;  
  	private Integer destinationSafeClient;  
  	private Integer destinationSafeWorker;  
  	private Integer posAdultConnections;
  	private Integer posPeerConnections;  
  	private Integer posCommunityConnections;
	public UUID getExitrhyId() {
		return exitrhyId;
	}
	public void setExitrhyId(UUID exitrhyId) {
		this.exitrhyId = exitrhyId;
	}
	public Integer getEarlyExitReason() {
		return earlyExitReason;
	}
	public void setEarlyExitReason(Integer earlyExitReason) {
		this.earlyExitReason = earlyExitReason;
	}
	public UUID getExitid() {
		return exitid;
	}
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}
	public Integer getProjectCompletionStatus() {
		return projectCompletionStatus;
	}
	public void setProjectCompletionStatus(Integer projectCompletionStatus) {
		this.projectCompletionStatus = projectCompletionStatus;
	}
	public Integer getExchangeForSex() {
		return exchangeForSex;
	}
	public void setExchangeForSex(Integer exchangeForSex) {
		this.exchangeForSex = exchangeForSex;
	}
	public Integer getExchangeForSexPastThreeMonths() {
		return exchangeForSexPastThreeMonths;
	}
	public void setExchangeForSexPastThreeMonths(Integer exchangeForSexPastThreeMonths) {
		this.exchangeForSexPastThreeMonths = exchangeForSexPastThreeMonths;
	}
	public Integer getCountOfExchangeForSex() {
		return countOfExchangeForSex;
	}
	public void setCountOfExchangeForSex(Integer countOfExchangeForSex) {
		this.countOfExchangeForSex = countOfExchangeForSex;
	}
	public Integer getAskedOrForcedToExchangeForSex() {
		return askedOrForcedToExchangeForSex;
	}
	public void setAskedOrForcedToExchangeForSex(Integer askedOrForcedToExchangeForSex) {
		this.askedOrForcedToExchangeForSex = askedOrForcedToExchangeForSex;
	}
	public Integer getAskedOrForcedToExchangeForSexPastThreeMonths() {
		return askedOrForcedToExchangeForSexPastThreeMonths;
	}
	public void setAskedOrForcedToExchangeForSexPastThreeMonths(Integer askedOrForcedToExchangeForSexPastThreeMonths) {
		this.askedOrForcedToExchangeForSexPastThreeMonths = askedOrForcedToExchangeForSexPastThreeMonths;
	}
	public Integer getWorkPlaceViolenceThreats() {
		return workPlaceViolenceThreats;
	}
	public void setWorkPlaceViolenceThreats(Integer workPlaceViolenceThreats) {
		this.workPlaceViolenceThreats = workPlaceViolenceThreats;
	}
	public Integer getWorkPlacePromiseDifference() {
		return workPlacePromiseDifference;
	}
	public void setWorkPlacePromiseDifference(Integer workPlacePromiseDifference) {
		this.workPlacePromiseDifference = workPlacePromiseDifference;
	}
	public Integer getCoercedToContinueWork() {
		return coercedToContinueWork;
	}
	public void setCoercedToContinueWork(Integer coercedToContinueWork) {
		this.coercedToContinueWork = coercedToContinueWork;
	}
	public Integer getLaborExploitPastThreeMonths() {
		return laborExploitPastThreeMonths;
	}
	public void setLaborExploitPastThreeMonths(Integer laborExploitPastThreeMonths) {
		this.laborExploitPastThreeMonths = laborExploitPastThreeMonths;
	}
	public Integer getCounselingReceived() {
		return counselingReceived;
	}
	public void setCounselingReceived(Integer counselingReceived) {
		this.counselingReceived = counselingReceived;
	}
	public Integer getIndividualCounseling() {
		return individualCounseling;
	}
	public void setIndividualCounseling(Integer individualCounseling) {
		this.individualCounseling = individualCounseling;
	}
	public Integer getFamilyCounseling() {
		return familyCounseling;
	}
	public void setFamilyCounseling(Integer familyCounseling) {
		this.familyCounseling = familyCounseling;
	}
	public Integer getGroupCounseling() {
		return groupCounseling;
	}
	public void setGroupCounseling(Integer groupCounseling) {
		this.groupCounseling = groupCounseling;
	}
	public Integer getSessionCountAtExit() {
		return sessionCountAtExit;
	}
	public void setSessionCountAtExit(Integer sessionCountAtExit) {
		this.sessionCountAtExit = sessionCountAtExit;
	}
	public Integer getSessionsInPlan() {
		return sessionsInPlan;
	}
	public void setSessionsInPlan(Integer sessionsInPlan) {
		this.sessionsInPlan = sessionsInPlan;
	}
	public Integer getPostExitCounselingPlan() {
		return postExitCounselingPlan;
	}
	public void setPostExitCounselingPlan(Integer postExitCounselingPlan) {
		this.postExitCounselingPlan = postExitCounselingPlan;
	}
	public Integer getDestinationSafeClient() {
		return destinationSafeClient;
	}
	public void setDestinationSafeClient(Integer destinationSafeClient) {
		this.destinationSafeClient = destinationSafeClient;
	}
	public Integer getDestinationSafeWorker() {
		return destinationSafeWorker;
	}
	public void setDestinationSafeWorker(Integer destinationSafeWorker) {
		this.destinationSafeWorker = destinationSafeWorker;
	}
	public Integer getPosAdultConnections() {
		return posAdultConnections;
	}
	public void setPosAdultConnections(Integer posAdultConnections) {
		this.posAdultConnections = posAdultConnections;
	}
	public Integer getPosPeerConnections() {
		return posPeerConnections;
	}
	public void setPosPeerConnections(Integer posPeerConnections) {
		this.posPeerConnections = posPeerConnections;
	}
	public Integer getPosCommunityConnections() {
		return posCommunityConnections;
	}
	public void setPosCommunityConnections(Integer posCommunityConnections) {
		this.posCommunityConnections = posCommunityConnections;
	}
  	

 }
