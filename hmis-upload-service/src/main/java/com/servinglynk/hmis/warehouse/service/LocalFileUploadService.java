package com.servinglynk.hmis.warehouse.service;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.model.FileInfo;

@Service
public class LocalFileUploadService{
	
    public FileInfo uploadFile(MultipartFile inputFile) {
    	FileInfo fileInfo = new FileInfo();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				String fileNameWithoutExtension = FilenameUtils.removeExtension(originalFilename);
				String fileExtension = FilenameUtils.getExtension(inputFile.getOriginalFilename());
				
				File destinationFile = File.createTempFile(fileNameWithoutExtension, fileExtension);
				inputFile.transferTo(destinationFile);
				fileInfo.setFileName(destinationFile.getPath());
				fileInfo.setFileSize((int)inputFile.getSize());
				
				return fileInfo;
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
    }

}
