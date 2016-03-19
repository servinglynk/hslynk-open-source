package com.servinglynk.hmis.warehouse.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.model.v2014.BulkUpload;

public class ExportDomain {
	
	public ExportDomain()
	{
		
	}
	
	public ExportDomain(Export export, Source source,
			Map<String, UUID> enrollmentProjectEntryIDMap,
			Map<String, UUID> clientPersonalIDMap, UUID exportId,
			UUID sourceId, Map<String, UUID> exitMap,
			Map<String, UUID> projectCocMap,
			Map<String, UUID> organizationProjectMap,
			Map<String, UUID> affiliationProjectMap,
			Map<String, UUID> bedInventoryMap) {
		super();
		this.export = export;
		this.source = source;
		this.enrollmentProjectEntryIDMap = enrollmentProjectEntryIDMap;
		this.clientPersonalIDMap = clientPersonalIDMap;
		this.exportId = exportId;
		this.sourceId = sourceId;
		this.exitMap = exitMap;
		this.projectCocMap = projectCocMap;
		this.organizationProjectMap = organizationProjectMap;
		this.affiliationProjectMap = affiliationProjectMap;
		this.bedInventoryMap = bedInventoryMap;
	}

	private Export export;
	private Source source;
	private Map<String, UUID> enrollmentProjectEntryIDMap = new HashMap<>();
	private Map<String,UUID> clientPersonalIDMap = new HashMap<>();
	private UUID exportId;
	private UUID sourceId;
	private  Map<String, UUID> exitMap = new HashMap<>();
	private Map<String, UUID> projectCocMap = new HashMap<>();
	private Map<String, UUID> organizationProjectMap = new HashMap<>();
	private Map<String, UUID> affiliationProjectMap = new HashMap<>();
	private Map<String,UUID> bedInventoryMap = new HashMap<>();
	private BulkUpload upload;
	
	public Export getExport() {
		return export;
	}
	public void setExport(Export export) {
		this.export = export;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Map<String, UUID> getEnrollmentProjectEntryIDMap() {
		return enrollmentProjectEntryIDMap;
	}
	public void setEnrollmentProjectEntryIDMap(
			Map<String, UUID> enrollmentProjectEntryIDMap) {
		this.enrollmentProjectEntryIDMap = enrollmentProjectEntryIDMap;
	}
	public UUID getExportId() {
		return exportId;
	}
	public void setExportId(UUID exportId) {
		this.exportId = exportId;
	}
	public UUID getSourceId() {
		return sourceId;
	}
	public void setSourceId(UUID sourceId) {
		this.sourceId = sourceId;
	}
	public Map<String, UUID> getClientPersonalIDMap() {
		return clientPersonalIDMap;
	}
	public void setClientPersonalIDMap(Map<String, UUID> clientPersonalIDMap) {
		this.clientPersonalIDMap = clientPersonalIDMap;
	}
	public Map<String, UUID> getExitMap() {
		return exitMap;
	}
	public void setExitMap(Map<String, UUID> exitMap) {
		this.exitMap = exitMap;
	}

	public Map<String, UUID> getProjectCocMap() {
		return projectCocMap;
	}

	public void setProjectCocMap(Map<String, UUID> projectCocMap) {
		this.projectCocMap = projectCocMap;
	}

	public Map<String, UUID> getOrganizationProjectMap() {
		return organizationProjectMap;
	}

	public void setOrganizationProjectMap(Map<String, UUID> organizationProjectMap) {
		this.organizationProjectMap = organizationProjectMap;
	}

	public Map<String, UUID> getAffiliationProjectMap() {
		return affiliationProjectMap;
	}

	public void setAffiliationProjectMap(Map<String, UUID> affiliationProjectMap) {
		this.affiliationProjectMap = affiliationProjectMap;
	}

	public Map<String, UUID> getBedInventoryMap() {
		return bedInventoryMap;
	}

	public void setBedInventoryMap(Map<String, UUID> bedInventoryMap) {
		this.bedInventoryMap = bedInventoryMap;
	}

	public BulkUpload getUpload() {
		return upload;
	}

	public void setUpload(BulkUpload upload) {
		this.upload = upload;
	}
	
}
