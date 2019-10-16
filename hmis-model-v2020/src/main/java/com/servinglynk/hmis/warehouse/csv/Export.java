package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Export {
	@MapToColumn(column=0)
	private String ExportID;
	@MapToColumn(column=1)
	private String SourceType;
	@MapToColumn(column=2)
	private String SourceID;
	@MapToColumn(column=3)
	private String SourceName;
	@MapToColumn(column=4)
	private String SourceContactFirst;
	@MapToColumn(column=5)
	private String SourceContactLast;
	@MapToColumn(column=6)
	private String SourceContactPhone;
	@MapToColumn(column=7)
	private String SourceContactExtension;
	@MapToColumn(column=8)
	private String SourceContactEmail;
	@MapToColumn(column=9)
	private String ExportDate;
	@MapToColumn(column=10)
	private String ExportStartDate;
	@MapToColumn(column=11)
	private String ExportEndDate;
	@MapToColumn(column=12)
	private String SoftwareName;
	@MapToColumn(column=13)
	private String SoftwareVersion;
		
	@MapToColumn(column=14)
	private String ExportPeriodType;
	@MapToColumn(column=15)
	private String ExportDirective;
	@MapToColumn(column=16)
	private String HashStatus;
	public String getExportID() {
		return ExportID;
	}
	public void setExportID(String exportID) {
		ExportID = exportID;
	}
	
	/**
	 * @return the sourceType
	 */
	public String getSourceType() {
		return SourceType;
	}
	/**
	 * @param sourceType the sourceType to set
	 */
	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}
	public String getSourceID() {
		return SourceID;
	}
	public void setSourceID(String sourceID) {
		SourceID = sourceID;
	}
	public String getSourceName() {
		return SourceName;
	}
	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}
	public String getSourceContactFirst() {
		return SourceContactFirst;
	}
	public void setSourceContactFirst(String sourceContactFirst) {
		SourceContactFirst = sourceContactFirst;
	}
	public String getSourceContactLast() {
		return SourceContactLast;
	}
	public void setSourceContactLast(String sourceContactLast) {
		SourceContactLast = sourceContactLast;
	}
	public String getSourceContactPhone() {
		return SourceContactPhone;
	}
	public void setSourceContactPhone(String sourceContactPhone) {
		SourceContactPhone = sourceContactPhone;
	}
	public String getSourceContactExtension() {
		return SourceContactExtension;
	}
	public void setSourceContactExtension(String sourceContactExtension) {
		SourceContactExtension = sourceContactExtension;
	}
	public String getSourceContactEmail() {
		return SourceContactEmail;
	}
	public void setSourceContactEmail(String sourceContactEmail) {
		SourceContactEmail = sourceContactEmail;
	}
	public String getExportDate() {
		return ExportDate;
	}
	public void setExportDate(String exportDate) {
		ExportDate = exportDate;
	}
	public String getExportStartDate() {
		return ExportStartDate;
	}
	public void setExportStartDate(String exportStartDate) {
		ExportStartDate = exportStartDate;
	}
	public String getExportEndDate() {
		return ExportEndDate;
	}
	public void setExportEndDate(String exportEndDate) {
		ExportEndDate = exportEndDate;
	}
	public String getSoftwareName() {
		return SoftwareName;
	}
	public void setSoftwareName(String softwareName) {
		SoftwareName = softwareName;
	}
	public String getSoftwareVersion() {
		return SoftwareVersion;
	}
	public void setSoftwareVersion(String softwareVersion) {
		SoftwareVersion = softwareVersion;
	}
	public String getExportPeriodType() {
		return ExportPeriodType;
	}
	public void setExportPeriodType(String exportPeriodType) {
		ExportPeriodType = exportPeriodType;
	}
	public String getExportDirective() {
		return ExportDirective;
	}
	public void setExportDirective(String exportDirective) {
		ExportDirective = exportDirective;
	}
	public String getHashStatus() {
		return HashStatus;
	}
	public void setHashStatus(String hashStatus) {
		HashStatus = hashStatus;
	}
	
		
}
