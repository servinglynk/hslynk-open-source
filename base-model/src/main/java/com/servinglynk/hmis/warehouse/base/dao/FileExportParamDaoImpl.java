package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.FileExportParamEntity;

public class FileExportParamDaoImpl extends QueryExecutorImpl implements FileExportParamDao {

	@Override
	public FileExportParamEntity createFileExportParam(FileExportParamEntity FileExportParamEntity) {
		insert(FileExportParamEntity);
		return FileExportParamEntity;
	}

	@Override
	public FileExportParamEntity updateFileExportParam(FileExportParamEntity FileExportParamEntity) {
		update(FileExportParamEntity);
		return FileExportParamEntity;
	}

	@Override
	public void deleteFileExportParam(FileExportParamEntity reportConfigParamEntity) {
		delete(reportConfigParamEntity);
	}

	@Override
	public FileExportParamEntity getFileExportParamByid(Long id) {
		return (FileExportParamEntity) get(FileExportParamEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileExportParamEntity> getFileExportParams(Long id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(FileExportParamEntity.class);
		criteria.add(Restrictions.eq("reportConfigId", id));
		return (List<FileExportParamEntity>) findByCriteria(criteria);
	}
}
