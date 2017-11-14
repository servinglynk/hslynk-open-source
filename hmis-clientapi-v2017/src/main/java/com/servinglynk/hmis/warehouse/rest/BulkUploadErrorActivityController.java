package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadActivities;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadErrors;

@RestController
@RequestMapping("/bulkupload")
public class BulkUploadErrorActivityController extends ControllerBase {
	
	  @RequestMapping(value="/activities/{bulkuploadId}",method=RequestMethod.GET)
	  @APIMapping(value="GET_BULK_ACTIVITIES",checkSessionToken=false,checkTrustedApp=false)
	   public BulkUploadActivities getBulkUploadActivities(@PathVariable( "bulkuploadId" ) Long bulkUploadId,HttpServletRequest request) throws Exception{
	        return serviceFactory.getBulkUploadErrorActivityService().getBulkUploadActivities(bulkUploadId); 
	   }
	  

	  @RequestMapping(value="/errors/{bulkuploadId}",method=RequestMethod.GET)
	  @APIMapping(value="GET_BULK_ERRORS",checkSessionToken=false,checkTrustedApp=false)
	   public BulkUploadErrors getBulkUploadErrors(@PathVariable( "bulkuploadId" ) Long bulkUploadId,HttpServletRequest request) throws Exception{
	        return serviceFactory.getBulkUploadErrorActivityService().getBulkUploadErrors(bulkUploadId); 
	   }
}
