package com.servinglynk.hmis.warehouse.rest;

import java.net.URL;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.FileInfo;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.service.AWSService;
import com.servinglynk.hmis.warehouse.service.LocalFileUploadService;

@RestController
@RequestMapping("/upload")
public class FileUploadController  extends ControllerBase {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	
	@Autowired
	AWSService awsService;
	
	@Autowired
	LocalFileUploadService localFileUploadService;

	 	
		/**
		 * Upload single file using Spring Controller
		 */
	 	@RequestMapping(method = RequestMethod.POST,headers = "content-type=multipart/*")
	 	@APIMapping(value="USR_BULK_UPLOAD",checkSessionToken=false, checkTrustedApp=false)
	    public ResponseEntity<FileInfo> logoUploadPost(@RequestPart("file") MultipartFile file,HttpServletRequest request,@RequestParam(value ="year", required = false) String year) {
	    	//Uploading file to local fileSystem
			FileInfo fileInfo = localFileUploadService.uploadFile(file);

			if(fileInfo != null) {

				String generatedFileName = Paths.get(fileInfo.getFileName()).getFileName().toString();

				//Uploading file from local fileSystem to AWS
				try {
					awsService.uploadFile(fileInfo.getFileName(), file.getName());
					
				}catch (Exception e) {
					System.out.println("Exception while uploading file." + e.getMessage());
					//throw e;
					//return new ResponseEntity<FileInfo>(HttpStatus.FORBIDDEN);
				}
				
				URL preSignedURL = awsService.getFile("logos/"+generatedFileName);
				fileInfo.setFileName(preSignedURL.toString());
				Session session = sessionHelper.getSession(request);
				com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new BulkUpload();
				upload.setInputpath(fileInfo.getFileName());
				upload.setSize(new Long(fileInfo.getFileSize()));
				if(StringUtils.isEmpty(year)) {
					throw new IllegalArgumentException("Year cannot be null.");
				}else{
					Long parseInt = Long.parseLong(year);
					upload.setYear(parseInt);
				}
				Account account = session.getAccount();
				try {
					serviceFactory.getBulkUploadService().createBulkUploadEntry(upload,account);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);
			}else{
				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.BAD_REQUEST);
			}
	    }

	
		}
