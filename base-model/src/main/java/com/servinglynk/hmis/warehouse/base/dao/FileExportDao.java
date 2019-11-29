package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.FileExportEntity;

public interface FileExportDao {

	FileExportEntity createFileExport(FileExportEntity reportConfigEntity);

	FileExportEntity updateFileExport(FileExportEntity reportConfigEntity);

	void deleteFileExport(FileExportEntity reportConfigEntity);

	FileExportEntity getFileExportByid(Long id);

	List<FileExportEntity> getFileExports(String projectGroupCode);

	List<FileExportEntity> getFileExportByUsername(String username);

	List<FileExportEntity> getFileExportByStatusEmailSent(String status, boolean emailSent);
}
