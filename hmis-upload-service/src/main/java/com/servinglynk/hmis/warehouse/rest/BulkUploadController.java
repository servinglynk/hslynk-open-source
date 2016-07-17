package com.servinglynk.hmis.warehouse.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.core.model.Session;
@RestController
@RequestMapping("/bulkupload")
public class BulkUploadController extends ControllerBase{
	private static final Logger logger = LoggerFactory
			.getLogger(BulkUploadController.class);
	 
	 /**
		 * Upload single file using Spring Controller
		 */
	@RequestMapping(method = RequestMethod.GET)
 	@APIMapping(value="GET_USR_BULK_UPLOAD",checkSessionToken=true, checkTrustedApp=true)
		public @ResponseBody
		BulkUploads  getBulkUploadedFiles(@RequestParam(value ="status", required = false) String status,
			    @RequestParam(value="startIndex", required=false) Integer startIndex, 
                @RequestParam(value="maxItems", required=false) Integer maxItems,
				HttpServletRequest request) {
		  if (startIndex == null) startIndex =0;
          if (maxItems == null) maxItems =30;
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

	@RequestMapping(value="/downloadLogFile")
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
