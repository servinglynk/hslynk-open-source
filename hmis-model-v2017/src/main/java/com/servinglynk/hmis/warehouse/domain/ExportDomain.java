package com.servinglynk.hmis.warehouse.domain;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;

public class ExportDomain {
	
	public ExportDomain()
	{
		
	}
	
	public ExportDomain(Export export, Source source, UUID exportId) {
		super();
		this.export = export;
		this.source = source;
	}

	private Export export;
	private Source source;
	private BulkUpload upload;
	private UUID userId;
	private UUID exportId;
	private boolean reUpload;
	private boolean reloadAll;
	private boolean fullRefresh;
	
	
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
	public BulkUpload getUpload() {
		return upload;
	}

	public void setUpload(BulkUpload upload) {
		this.upload = upload;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	/**
	 * @return the exportId
	 */
	public UUID getExportId() {
		return exportId;
	}

	/**
	 * @param exportId the exportId to set
	 */
	public void setExportId(UUID exportId) {
		this.exportId = exportId;
	}

	/**
	 * @return the reUpload
	 */
	public boolean isReUpload() {
		return reUpload;
	}

	/**
	 * @param reUpload the reUpload to set
	 */
	public void setReUpload(boolean reUpload) {
		this.reUpload = reUpload;
	}

	/**
	 * @return the reloadAll
	 */
	public boolean isReloadAll() {
		return reloadAll;
	}

	/**
	 * @param reloadAll the reloadAll to set
	 */
	public void setReloadAll(boolean reloadAll) {
		this.reloadAll = reloadAll;
	}

	/**
	 * @return the fullRefresh
	 */
	public boolean isFullRefresh() {
		return fullRefresh;
	}

	/**
	 * @param fullRefresh the fullRefresh to set
	 */
	public void setFullRefresh(boolean fullRefresh) {
		this.fullRefresh = fullRefresh;
	}
	
}
