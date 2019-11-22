package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.FileExportService;
import com.servinglynk.hmis.warehouse.base.service.converter.FileExportConverter;
import com.servinglynk.hmis.warehouse.core.model.FileExport;
import com.servinglynk.hmis.warehouse.core.model.FileExports;
import com.servinglynk.hmis.warehouse.core.model.ReportProject;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.FileExportEntity;
import com.servinglynk.hmis.warehouse.model.base.FileExportParamEntity;

public class FileExportServiceImpl  extends ServiceBase implements FileExportService {

	@Override
	@Transactional
	public FileExport createFileExport(FileExport FileExport, String caller) {
		FileExportEntity FileExportEntity = new FileExportEntity();
		FileExport.setCreatedBy(caller);
		FileExport.setUpdatedBy(caller);
		FileExport.setStatus("INITIAL");
		HmisUser user = daoFactory.getAccountDao().findByUsername(caller);
		FileExport.setProjectGroupCode(user.getProjectGroupCode());
		FileExportEntity modelToEntity = FileExportConverter.modelToEntity(FileExportEntity, FileExport);
		FileExportEntity createFileExport = daoFactory.getFileExportDao().createFileExport(modelToEntity);
		List<ReportProject> reportProjects = FileExport.getProjectIds();
		if(CollectionUtils.isNotEmpty(reportProjects)) {
			 for(ReportProject reportProject : reportProjects) {
				 FileExportParamEntity FileExportParamEntity = new FileExportParamEntity();
				 FileExportParamEntity.setCreatedBy(caller);
				 FileExportParamEntity.setUpdatedBy(caller);
				 FileExportParamEntity.setKey("PROJECT_ID");
				 FileExportParamEntity.setValue(reportProject.getProjectId());
				 FileExportParamEntity.setFileExport(createFileExport);
				 FileExportParamEntity.setStatus("ACTIVE");
				 daoFactory.getFileExportParamDao().createFileExportParam(FileExportParamEntity);
			 }
		 }
		return FileExportConverter.entityToModel(createFileExport);
	}

	@Override
	@Transactional
	public FileExport updateFileExport(Long FileExportId, FileExport FileExport, String caller) {
		FileExportEntity FileExportByid = daoFactory.getFileExportDao().getFileExportByid(FileExportId);
		FileExportEntity modelToEntity = FileExportConverter.modelToEntity(FileExportByid, FileExport);
		FileExportEntity updatedFileExport = daoFactory.getFileExportDao().updateFileExport(modelToEntity);
		return FileExportConverter.entityToModel(updatedFileExport);
	}

	@Override
	@Transactional
	public FileExport deleteFileExport(Long FileExportId) {
		FileExportEntity FileExportByid = daoFactory.getFileExportDao().getFileExportByid(FileExportId);
		if(FileExportByid != null) {
			daoFactory.getFileExportDao().deleteFileExport(FileExportByid);
		}
		return FileExportConverter.entityToModel(FileExportByid);
	}

	@Override
	@Transactional
	public FileExport getFileExportById(Long FileExportid) {
		FileExportEntity FileExportByid = daoFactory.getFileExportDao().getFileExportByid(FileExportid);
		return FileExportConverter.entityToModel(FileExportByid);
	}

	@Override
	@Transactional
	public FileExports getFileExportByStatusEmailSent(String status,boolean emailSent) {
		List<FileExportEntity> FileExportsEntity = daoFactory.getFileExportDao().getFileExportByStatusEmailSent(status,emailSent);
		FileExports FileExports = new FileExports();
		List<FileExport> FileExportList = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(FileExportsEntity)) {
			for(FileExportEntity FileExportEntity : FileExportsEntity) {
				FileExportList.add(FileExportConverter.entityToModel(FileExportEntity));
			}
		}
		FileExports.setFileExports(FileExportList);
		return FileExports;
	}

	
	@Override
	@Transactional
	public FileExports getFileExportsByUser(Integer startIndex, Integer maxItems,String caller) {
		List<FileExportEntity> FileExportsEntity = daoFactory.getFileExportDao().getFileExportByUsername(caller);
		FileExports FileExports = new FileExports();
		List<FileExport> FileExportList = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(FileExportsEntity)) {
			for(FileExportEntity FileExportEntity : FileExportsEntity) {
				FileExportList.add(FileExportConverter.entityToModel(FileExportEntity));
			}
		}
		FileExports.setFileExports(FileExportList);
		return FileExports;
	}
	@Override
	@Transactional
	public FileExports getAllFileExports(Integer startIndex, Integer maxItems) {
		return null;
	}

}
