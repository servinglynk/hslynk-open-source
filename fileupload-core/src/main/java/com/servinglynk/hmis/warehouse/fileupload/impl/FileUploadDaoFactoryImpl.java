package com.servinglynk.hmis.warehouse.fileupload.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.fileupload.repository.UploadHeaderDao;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadLineDao;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadMimeTypeDao;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadTypeDao;
import com.servinglynk.hmis.warehouse.fileupload.service.FileUploadDaoFactory;

@Component
public class FileUploadDaoFactoryImpl implements FileUploadDaoFactory{
	
	@Autowired UploadHeaderDao uploadHeaderDao;
	@Autowired UploadLineDao uploadLineDao;
	@Autowired UploadTypeDao uploadTypeDao;
	@Autowired UploadMimeTypeDao uploadMimeTypeDao;
	
	public UploadHeaderDao getUploadHeaderDao() {
		return uploadHeaderDao;
	}
	public void setUploadHeaderDao(UploadHeaderDao uploadHeaderDao) {
		this.uploadHeaderDao = uploadHeaderDao;
	}
	public UploadLineDao getUploadLineDao() {
		return uploadLineDao;
	}
	public void setUploadLineDao(UploadLineDao uploadLineDao) {
		this.uploadLineDao = uploadLineDao;
	}
	public UploadTypeDao getUploadTypeDao() {
		return uploadTypeDao;
	}
	public void setUploadTypeDao(UploadTypeDao uploadTypeDao) {
		this.uploadTypeDao = uploadTypeDao;
	}
	public UploadMimeTypeDao getUploadMimeTypeDao() {
		return uploadMimeTypeDao;
	}
	public void setUploadMimeTypeDao(UploadMimeTypeDao uploadMimeTypeDao) {
		this.uploadMimeTypeDao = uploadMimeTypeDao;
	}
}