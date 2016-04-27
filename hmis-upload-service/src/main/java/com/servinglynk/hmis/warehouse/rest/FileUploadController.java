package com.servinglynk.hmis.warehouse.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
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
		String uploadFileHandler(@RequestParam(value ="name", required = false) String name,
				@RequestParam("file") MultipartFile file,HttpServletRequest request) {

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + file.getOriginalFilename());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					logger.info("Server File Location="
							+ serverFile.getAbsolutePath());
					Session session = sessionHelper.getSession(request);
					com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new BulkUpload();
					upload.setInputpath(serverFile.getAbsolutePath());
					upload.setSize(file.getSize());
					//upload.setProjectGroupCode(projGrpCode);
					//upload.setUser(user);(session.getAccount().getUsername());
					serviceFactory.getBulkUploadService().createBulkUploadEntry(upload );

					return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					return "You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + name
						+ " because the file was empty.";
			}
		}
}
