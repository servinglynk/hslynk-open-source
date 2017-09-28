package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("question")
public class Question extends ClientModel {

	private UUID questionId;

	private String projectGroupId;

	private String questionDescription;

	private String displayText;

	private String questionDataType;

	private String questionType;

	private String picklistGroupName;

	private String hudQuestionId;
	
	private List<ActionLink> links;

	public UUID getQuestionId() {
		return questionId;
	}

	public void setQuestionId(UUID questionId) {
		this.questionId = questionId;
	}

	public String getProjectGroupId() {
		return projectGroupId;
	}

	public void setProjectGroupId(String projectGroupId) {
		this.projectGroupId = projectGroupId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getQuestionDataType() {
		return questionDataType;
	}

	public void setQuestionDataType(String questionDataType) {
		this.questionDataType = questionDataType;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getPicklistGroupName() {
		return picklistGroupName;
	}

	public void setPicklistGroupName(String picklistGroupName) {
		this.picklistGroupName = picklistGroupName;
	}

	public String getHudQuestionId() {
		return hudQuestionId;
	}

	public void setHudQuestionId(String hudQuestionId) {
		this.hudQuestionId = hudQuestionId;
	}

	public List<ActionLink> getLinks() {
		return links;
	}

	public void setLinks(List<ActionLink> links) {
		this.links = links;
	}
	public void addLink(ActionLink link) {
		if(this.links==null) this.links = new ArrayList<ActionLink>();
		this.links.add(link);		
	}
}