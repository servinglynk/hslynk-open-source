package com.servinglynk.hmis.warehouse.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;

@RestController
@RequestMapping("/upload")
public class FileUploadController  extends ControllerBase {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	 

		/**
		 * Upload single file using Spring Controller
		 */
	 	@RequestMapping(method = RequestMethod.POST,headers = "content-type=multipart/*")
	 	@APIMapping(value="USR_BULK_UPLOAD",checkSessionToken=true, checkTrustedApp=true)
		public @ResponseBody
		String uploadFileHandler(@RequestParam(value ="year", required = false) String year,
				@RequestParam(value="fileName", required = false) String fileName,@RequestParam(value="bucketName", required = false) String bucketName,@RequestParam(value="fileSize", required = false) String fileSize, HttpServletRequest request) {
				try {
					logger.info("Server File Location=");
					Session session = sessionHelper.getSession(request);
					com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new BulkUpload();
					upload.setInputpath("");
					upload.setSize(0L);
					if(StringUtils.isEmpty(year)) {
						throw new IllegalArgumentException("Year cannot be null.");
					}else{
						Long parseInt = Long.parseLong(year);
						upload.setYear(parseInt);
					}
					Account account = session.getAccount();
					serviceFactory.getBulkUploadService().createBulkUploadEntry(upload,account);

					return "You successfully uploaded file=" + fileName;
				} catch (Exception e) {
					logger.error("Error while uploading file {}",e.getMessage());
				}
			 	return null;
			}
	
		}
