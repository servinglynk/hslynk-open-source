package com.servinglynk.hmis.warehouse;

import java.sql.Timestamp;

public class EligibleClient {
	private String client_id;
	private String survey_type;
	private int survey_score;
	private String program_type;
	private boolean matched;
	private Timestamp survey_date;
	private String spdat_label;
	private String zip_code;
	private String project_group_code;
	private int coc_score;
	private String client_link;
	private Timestamp date_created;
	private Timestamp date_updated;
	private String user_id;
	private boolean deleted;
	private boolean ignore_match_process;
	private String remarks;
	private String status;
	private String client_dedup_id;
	private Timestamp survey_submission_date;
	private int bonus_score;
	private int total_score;
	private String readded_reason;
	
	
	public EligibleClient(String client_id, String survey_type, int survey_score, String program_type, boolean matched,
			Timestamp survey_date, String spdat_label, String zip_code, String project_group_code, int coc_score,
			String client_link, Timestamp date_created, Timestamp date_updated, String user_id, boolean deleted,
			boolean ignore_match_process, String remarks, String status, String client_dedup_id,
			Timestamp survey_submission_date, int bonus_score, int total_score, String readded_reason) {
		super();
		this.client_id = client_id;
		this.survey_type = survey_type;
		this.survey_score = survey_score;
		this.program_type = program_type;
		this.matched = matched;
		this.survey_date = survey_date;
		this.spdat_label = spdat_label;
		this.zip_code = zip_code;
		this.project_group_code = project_group_code;
		this.coc_score = coc_score;
		this.client_link = client_link;
		this.date_created = date_created;
		this.date_updated = date_updated;
		this.user_id = user_id;
		this.deleted = deleted;
		this.ignore_match_process = ignore_match_process;
		this.remarks = remarks;
		this.status = status;
		this.client_dedup_id = client_dedup_id;
		this.survey_submission_date = survey_submission_date;
		this.bonus_score = bonus_score;
		this.total_score = total_score;
		this.readded_reason = readded_reason;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getSurvey_type() {
		return survey_type;
	}
	public void setSurvey_type(String survey_type) {
		this.survey_type = survey_type;
	}
	public int getSurvey_score() {
		return survey_score;
	}
	public void setSurvey_score(int survey_score) {
		this.survey_score = survey_score;
	}
	public String getProgram_type() {
		return program_type;
	}
	public void setProgram_type(String program_type) {
		this.program_type = program_type;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	public Timestamp getSurvey_date() {
		return survey_date;
	}
	public void setSurvey_date(Timestamp survey_date) {
		this.survey_date = survey_date;
	}
	public String getSpdat_label() {
		return spdat_label;
	}
	public void setSpdat_label(String spdat_label) {
		this.spdat_label = spdat_label;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getProject_group_code() {
		return project_group_code;
	}
	public void setProject_group_code(String project_group_code) {
		this.project_group_code = project_group_code;
	}
	public int getCoc_score() {
		return coc_score;
	}
	public void setCoc_score(int coc_score) {
		this.coc_score = coc_score;
	}
	public String getClient_link() {
		return client_link;
	}
	public void setClient_link(String client_link) {
		this.client_link = client_link;
	}
	public Timestamp getDate_created() {
		return date_created;
	}
	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}
	public Timestamp getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(Timestamp date_updated) {
		this.date_updated = date_updated;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isIgnore_match_process() {
		return ignore_match_process;
	}
	public void setIgnore_match_process(boolean ignore_match_process) {
		this.ignore_match_process = ignore_match_process;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClient_dedup_id() {
		return client_dedup_id;
	}
	public void setClient_dedup_id(String client_dedup_id) {
		this.client_dedup_id = client_dedup_id;
	}
	public Timestamp getSurvey_submission_date() {
		return survey_submission_date;
	}
	public void setSurvey_submission_date(Timestamp survey_submission_date) {
		this.survey_submission_date = survey_submission_date;
	}
	public int getBonus_score() {
		return bonus_score;
	}
	public void setBonus_score(int bonus_score) {
		this.bonus_score = bonus_score;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public String getReadded_reason() {
		return readded_reason;
	}
	public void setReadded_reason(String readded_reason) {
		this.readded_reason = readded_reason;
	}
}
