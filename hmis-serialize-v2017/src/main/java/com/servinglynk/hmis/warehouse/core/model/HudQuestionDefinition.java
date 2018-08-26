package com.servinglynk.hmis.warehouse.core.model;

import java.util.HashMap;
import java.util.Map;

public class HudQuestionDefinition {

	private String questionType;
	private String title;
	private Map<String, String> options;
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<String, String> getOptions() {
		if(this.options==null) return new HashMap<String,String>();
		return options;
	}
	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
	
}