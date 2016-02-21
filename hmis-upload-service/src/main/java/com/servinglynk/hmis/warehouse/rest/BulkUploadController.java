package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 			BulkUploads uploads = serviceFactory.getBulkUploadService().getBulkUploadsByStatus(status, session.getAccount(),startIndex, maxItems);
	 			return uploads;
			} catch (Exception e) {
				logger.error("Problems with getting the Bulk uploads"+e.getMessage());
			}
	 		return null;
		}

}
