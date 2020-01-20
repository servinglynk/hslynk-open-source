package com.servinglynk.hmis.warehouse.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUpload;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.FileInfo;
import com.servinglynk.hmis.warehouse.service.AWSService;
import com.servinglynk.hmis.warehouse.service.LocalFileUploadService;
@RestController
@RequestMapping({"/bulk-upload","/bulkupload"})
public class BulkUploadController extends ControllerBase{
	private static final Logger logger = LoggerFactory
			.getLogger(BulkUploadController.class);
	
	@Autowired
	AWSService awsService;
	
	@Autowired
	LocalFileUploadService localFileUploadService;
	 /**
		 * Upload single file using Spring Controller
		 */
	@RequestMapping(method = RequestMethod.GET)
 	@APIMapping(value="GET_USR_BULK_UPLOAD",checkSessionToken=true, checkTrustedApp=true)
		public BulkUploads  getBulkUploadedFiles(@RequestParam(value ="status", required = false) String status,
			    @RequestParam(value="startIndex", required=false) Integer startIndex, 
                @RequestParam(value="maxItems", required=false) Integer maxItems,
				HttpServletRequest request) {
		  if (startIndex == null) startIndex =0;
          if (maxItems == null) maxItems =20;
	 		try {
	 			Session session = sessionHelper.getSession(request);
	 			BulkUploads uploads = null;
	 			if(StringUtils.equals("RECENT", status)) {
	 				uploads	= serviceFactory.getBulkUploadService().getRecentUploads(session.getAccount(),startIndex, maxItems);
	 			} else {
	 				uploads  = serviceFactory.getBulkUploadService().getBulkUploadsByStatus(status, session.getAccount(),startIndex, maxItems);
	 			}
	 			 
	 			return uploads;
			} catch (Exception e) {
				logger.error("Problems with getting the Bulk uploads"+e.getMessage());
			}
	 		return null;
		}
	
	
	@RequestMapping(value="/{bulkUploadId}",method=RequestMethod.PUT)
	   @APIMapping(value="API_UPDATE_BULKUPLOAD",checkTrustedApp=true,checkSessionToken=true)
	   public void updateBulkUpload(@PathVariable( "bulkUploadId" ) String bulkUploadId,@RequestBody BulkUpload model,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        model.setId(Long.parseLong(bulkUploadId));
	        serviceFactory.getBulkUploadService().updateBulkUpload(model, session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{bulkUploadId}",method=RequestMethod.DELETE)
	   @APIMapping(value="API_DELETE_BULKUPLOAD",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteBulkUpload(@PathVariable( "bulkUploadId" ) String bulkUploadId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getBulkUploadService().deleteBulkUpload(Long.parseLong(bulkUploadId),session.getAccount().getUsername());
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{bulkUploadId}",method=RequestMethod.GET)
	   @APIMapping(value="API_GET_BULKUPLOAD_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public BulkUpload getBulkUploadById(@PathVariable( "bulkUploadId" ) String bulkUploadId,HttpServletRequest request) throws Exception{
	        return serviceFactory.getBulkUploadService().getBulkUploadId(Long.parseLong(bulkUploadId));
	   }
	
	/**
	 * Upload single file using Spring Controller
	 */
 	@RequestMapping(value="/{version}",method = RequestMethod.POST,headers = "content-type=multipart/*")
 	@APIMapping(value="API_POST_BULKUPLOAD",checkSessionToken=true, checkTrustedApp=true)
    public ResponseEntity<com.servinglynk.hmis.warehouse.core.model.BulkUpload> logoUploadPost(@RequestPart("file") MultipartFile file,HttpServletRequest request,@PathVariable( "version" ) String version) {
    	//Uploading file to local fileSystem
 		
		Session session = sessionHelper.getSession(request);
		com.servinglynk.hmis.warehouse.core.model.BulkUpload model = new com.servinglynk.hmis.warehouse.core.model.BulkUpload();
		model.setFileName(file.getOriginalFilename());
		model.setStatus("FILESYSTEM");
         String year ="2017";
         version = version.trim();
         if(StringUtils.equals("401", version))
        	 year = "2014";
         else if(StringUtils.equals("411", version))
        	 year = "2015";
         else if(StringUtils.equals("51", version))
        	 year = "2016";
         else if(StringUtils.equals("611", version) || StringUtils.equals("612", version))
        	 year = "2017";
         else if(StringUtils.equals("2020", version))
        	 year = "2020";	 
		if(StringUtils.isEmpty(year)) {
			throw new IllegalArgumentException("Year cannot be null.");
		}else{
			Long parseInt = Long.parseLong(year);
			model.setYear(parseInt);
		}
		model.setHudVersion(getHudVersionFromVersion(version));
		String username = session.getAccount().getUsername();
		try {
			model = serviceFactory.getBulkUploadService().createBulkUploadEntry(model,session.getAccount());
		} catch (Exception e) {
			logger.error("Exception while uploading file." + e.getMessage());
			return new ResponseEntity<com.servinglynk.hmis.warehouse.core.model.BulkUpload>(model, HttpStatus.BAD_REQUEST);
		}
		FileInfo fileInfo = localFileUploadService.uploadFile(file);
		model.setStatus("S3");
		if(fileInfo.getFileSize() !=null)
			model.setFileSize(fileInfo.getFileSize()+"");
		model = serviceFactory.getBulkUploadService().updateBulkUpload(model, username);
		if(fileInfo != null) {
			//Uploading file from local fileSystem to AWS
			try {
				Account account = serviceFactory.getAccountService().findAccountByUsername(username);
				ProjectGroup projectGroup = account.getProjectGroup();
				awsService.uploadFile(fileInfo.getFileName(), file.getOriginalFilename(),projectGroup.getBucketName());
			}catch (Exception e) {
				logger.error("Exception while uploading file." + e.getMessage());
				return new ResponseEntity<com.servinglynk.hmis.warehouse.core.model.BulkUpload>(HttpStatus.FORBIDDEN);
			}
			fileInfo.setFileName(file.getOriginalFilename());
			model.setStatus("INITIAL");
			model = serviceFactory.getBulkUploadService().updateBulkUpload(model, username);
			return new ResponseEntity<com.servinglynk.hmis.warehouse.core.model.BulkUpload>(model, HttpStatus.OK);
		}else{
			return new ResponseEntity<com.servinglynk.hmis.warehouse.core.model.BulkUpload>(model, HttpStatus.BAD_REQUEST);
		}
    }


	@RequestMapping(value="/downloadLogFile",method = RequestMethod.POST)
	public void downloadFile(@RequestParam(value ="fileName", required = false) String fileName,
			HttpServletRequest request, HttpServletResponse response) {
		try {
	        String filePathToBeServed = "";//complete file name with path;
	        File fileToDownload = new File("/proj/bulkupload/2014/hmis-load-processor-v2014-0.0.2-SNAPSHOT/logs/hmis-load-processor-v2014.log");
	        InputStream inputStream = new FileInputStream(fileToDownload);
	        response.setContentType("application/force-download");
	        response.setHeader("Content-Disposition", "attachment; filename="+fileName+".log"); 
	        IOUtils.copy(inputStream, response.getOutputStream());
	        response.flushBuffer();
	        inputStream.close();
	    } catch (Exception e){
	        logger.debug("Request could not be completed at this moment. Please try again.");
	        e.printStackTrace();
	    }
	}
}
