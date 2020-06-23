package com.servinglynk.hmis.warehouse.model.base;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@Document(indexName = "clientmetadata",type="com.servinglynk.hmis.warehouse.model.base.ClientMetaData")
@JsonNaming(value = PropertyNamingStrategy.LowerCaseStrategy.class)
@Component
public class ClientMetaData {

	@org.springframework.data.annotation.Id
	private String id;
	@Field(name ="clientid",fielddata = true,type = FieldType.Text)
	private String clientid;
	@Field(name ="clientdedupid",fielddata = true,type = FieldType.Text)
	private String clientdedupid;
	@Field(name ="metadataidentifier",fielddata = true,type = FieldType.Text)
	private String metadataidentifier;
	@Field(name ="additionalinfo",fielddata = true,type = FieldType.Text)
	private String additionalinfo;
	private Date date;
	@Field(name ="type",fielddata = true,type = FieldType.Text)
	private String type;
	@Field(name ="projectgroupcode",fielddata = true,type = FieldType.Text)
	protected String projectgroupcode;
	private boolean deleted;
	protected Date datecreated = new Date();
	protected Date dateupdated = new Date();
	private UUID userid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getClientdedupid() {
		return clientdedupid;
	}
	public void setClientdedupid(String clientdedupid) {
		this.clientdedupid = clientdedupid;
	}
	public String getMetadataidentifier() {
		return metadataidentifier;
	}
	public void setMetadataidentifier(String metadataidentifier) {
		this.metadataidentifier = metadataidentifier;
	}
	public String getAdditionalinfo() {
		return additionalinfo;
	}
	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProjectgroupcode() {
		return projectgroupcode;
	}
	public void setProjectgroupcode(String projectgroupcode) {
		this.projectgroupcode = projectgroupcode;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public Date getDateupdated() {
		return dateupdated;
	}
	public void setDateupdated(Date dateupdated) {
		this.dateupdated = dateupdated;
	}
	public UUID getUserid() {
		return userid;
	}
	public void setUserid(UUID userid) {
		this.userid = userid;
	}
}