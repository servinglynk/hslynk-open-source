package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.sync.business.service.core.ParentServiceFactory;


@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	 @Autowired
		protected ParentServiceFactory parentServiceFactory;
	 

		/**
		 * Upload single file using Spring Controller
		 */
	 	@RequestMapping(method = RequestMethod.POST)
		public @ResponseBody
		String uploadFileHandler(@RequestParam(value ="name", required = false) String name,
				@RequestParam("file") MultipartFile file) {

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
							+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					logger.info("Server File Location="
							+ serverFile.getAbsolutePath());
					
					parentServiceFactory.getSyncService().createBulkUploadEntry( serverFile.getAbsolutePath());

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
