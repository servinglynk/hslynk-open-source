package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.FileExportParamEntity;

public interface FileExportParamDao {

	FileExportParamEntity createFileExportParam(FileExportParamEntity reportConfigParamEntity);

	FileExportParamEntity updateFileExportParam(FileExportParamEntity reportConfigParamEntity);

	void deleteFileExportParam(FileExportParamEntity reportConfigParamEntity);

	FileExportParamEntity getFileExportParamByid(Long id);
	
	List<FileExportParamEntity> getFileExportParams(Long reportConfigId);
}
