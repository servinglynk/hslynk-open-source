package com.servinglynk.hmis.warehouse.model.v2020;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="question",catalog = "hmis", schema = "v2020")
public class QuestionEntity  implements Cloneable, Serializable {

	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
	
	@Column(name="QUESTION_DESCRIPTION")
	private String questionDescription;
	
	@Column(name="DISPLAY_TEXT")
	private String displayText;
	
	@Column(name="QUESTION_TYPE")
	private String questionType;
	
	@Column(name="QUESTION_DATA_TYPE")
	private String questionDataType;
		
	@Column(name="picklist_group_name")
	private String picklistGroupName;
	
	@Column(name="hud_question_id")
	private String hudQuestionId;
	
	@Column(name="update_url_template")
	private String updateURLTemplate;
	
	@Column(name="uri_object_field")
	private String uriObjectField;
	
	@Column(name="question_group_id")
	private Long questionGroupId;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionDataType() {
		return questionDataType;
	}
	public void setQuestionDataType(String questionDataType) {
		this.questionDataType = questionDataType;
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
	public String getUpdateURLTemplate() {
		return updateURLTemplate;
	}
	public void setUpdateURLTemplate(String updateURLTemplate) {
		this.updateURLTemplate = updateURLTemplate;
	}
	public String getUriObjectField() {
		return uriObjectField;
	}
	public void setUriObjectField(String uriObjectField) {
		this.uriObjectField = uriObjectField;
	}
	public Long getQuestionGroupId() {
		return questionGroupId;
	}
	public void setQuestionGroupId(Long questionGroupId) {
		this.questionGroupId = questionGroupId;
	}
}