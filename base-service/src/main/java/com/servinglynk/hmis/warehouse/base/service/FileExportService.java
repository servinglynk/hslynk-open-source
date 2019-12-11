package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.FileExport;
import com.servinglynk.hmis.warehouse.core.model.FileExports;

public interface FileExportService {
	
	FileExport createFileExport(FileExport fileExport, String caller);
	FileExport updateFileExport(Long FileExportid ,FileExport FileExport, String caller);
	FileExport deleteFileExport(Long FileExportId);
	public FileExport getFileExportById(Long FileExportid);
	FileExports getAllFileExports(Integer startIndex, Integer maxItems);
	public FileExports getFileExportsByUser(Integer startIndex, Integer maxItems,String caller);
	FileExports getFileExportByStatusEmailSent(String status, boolean emailSent);

}
