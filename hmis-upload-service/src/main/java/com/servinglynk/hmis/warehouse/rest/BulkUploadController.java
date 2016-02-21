package com.servinglynk.hmis.warehouse.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.BulkUpload;
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
		List<BulkUpload> getBulkUploadedFiles(@RequestParam(value ="status", required = false) String status,HttpServletRequest request) {

	 		try {
	 			Session session = sessionHelper.getSession(request);
	 			List<BulkUpload> uploads = serviceFactory.getBulkUploadService().getBulkUploadsByStatus(status, session.getAccount());
	 			return uploads;
			} catch (Exception e) {
				logger.error("Problems with getting the Bulk uploads"+e.getMessage());
			}
	 		return null;
		}

}
