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
	
}
