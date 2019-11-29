package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.FileExportEntity;

public class FileExportDaoImpl extends QueryExecutorImpl implements FileExportDao {

	@Override
	public FileExportEntity createFileExport(FileExportEntity reportConfigEntity) {
		insert(reportConfigEntity);
		return reportConfigEntity;
	}

	@Override
	public FileExportEntity updateFileExport(FileExportEntity reportConfigEntity) {
		update(reportConfigEntity);
		return reportConfigEntity;
	}

	@Override
	public void deleteFileExport(FileExportEntity reportConfigEntity) {
		delete(reportConfigEntity);
	}

	@Override
	public FileExportEntity getFileExportByid(Long id) {
		return (FileExportEntity) get(FileExportEntity.class, id);
	}
	
	@Override
	public List<FileExportEntity> getFileExportByUsername(String username) {
		DetachedCriteria criteria=DetachedCriteria.forClass(FileExportEntity.class);
		criteria.add(Restrictions.eq("createdBy", username));
		return (List<FileExportEntity>) findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileExportEntity> getFileExportByStatusEmailSent(String status,boolean emailSent) {
		DetachedCriteria criteria=DetachedCriteria.forClass(FileExportEntity.class);
		criteria.add(Restrictions.eq("status", status));
		criteria.add(Restrictions.eq("emailSent", emailSent));
		return (List<FileExportEntity>) findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileExportEntity> getFileExports(String projectGroupCode) {
		DetachedCriteria criteria=DetachedCriteria.forClass(FileExportEntity.class);
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return (List<FileExportEntity>) findByCriteria(criteria);
	}
}
