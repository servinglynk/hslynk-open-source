package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.util.Date;

import com.servinglynk.hmis.warehouse.model.live.Export;

public class BulkUploadDTO {
	private Long id;
	private String inputPath;
	private String status;
	private Date insertAt ;
	private String insertBy;
	private Date updateAt;
	private String updateBy;
	/** Field mapping. */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInsertAt() {
		return insertAt;
	}
	public void setInsertAt(Date insertAt) {
		this.insertAt = insertAt;
	}
	public String getInsertBy() {
		return insertBy;
	}
	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
}