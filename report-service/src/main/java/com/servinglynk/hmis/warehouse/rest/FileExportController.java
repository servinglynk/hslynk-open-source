package com.servinglynk.hmis.warehouse.rest;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.FileExport;
import com.servinglynk.hmis.warehouse.core.model.FileExports;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.service.AWSService;


@RestController
@RequestMapping("/export")
public class FileExportController extends ControllerBase {
	@Autowired
	AWSService awsService;
	private static final int BUFFER_SIZE = 4096;
	
		@RequestMapping(method = RequestMethod.POST)
		@APIMapping(value="CREATE_FILE_EXPORT",checkSessionToken=true, checkTrustedApp=true)
		public FileExport createReport(@RequestBody FileExport fileExport,HttpServletRequest request) throws Exception {			
		 Session session = sessionHelper.getSession(request);
		 String username = session.getAccount().getUsername();
		 FileExport createFileExport = serviceFactory.getFileExportService().createFileExport(fileExport,username);
		 return createFileExport;
		}

	 	@RequestMapping(method = RequestMethod.GET)
		@APIMapping(value="GET_FILE_EXPORT_BY_USER",checkSessionToken=true, checkTrustedApp=true)
		public FileExports getReports(@RequestParam(value="startIndex", required=false) Integer startIndex, 
                @RequestParam(value="maxItems", required=false) Integer maxItems,HttpServletRequest request) throws Exception {			
		 Session session = sessionHelper.getSession(request);
		 String username = session.getAccount().getUsername();
		 return  serviceFactory.getFileExportService().getFileExportsByUser(startIndex, maxItems, username);
		}

		@RequestMapping(value="/{fileExportId}",method=RequestMethod.GET)
		@APIMapping(value="GET_FILE_EXPORT_BY_ID",checkSessionToken=true, checkTrustedApp=true)
		public FileExport getReportById(@PathVariable(value="fileExportId") Long fileExportId, 
                HttpServletRequest request) throws Exception {			
		 Session session = sessionHelper.getSession(request);
		 String username = session.getAccount().getUsername();
		 return  serviceFactory.getFileExportService().getFileExportById(fileExportId);
		}
		
		@RequestMapping(value="/{fileExportId}",method=RequestMethod.PUT)
		@APIMapping(value="UPDATE_FILE_EXPORT",checkSessionToken=true, checkTrustedApp=true)
		public FileExport updateById(@PathVariable(value="fileExportId") Long fileExportId, 
                HttpServletRequest request, @RequestBody FileExport fileExport) throws Exception {			
		 Session session = sessionHelper.getSession(request);
		 String username = session.getAccount().getUsername();
		 return  serviceFactory.getFileExportService().updateFileExport(fileExportId, fileExport, username);
		}
		
		@RequestMapping(value="/download/{fileExportId}/{type}",method = RequestMethod.GET)
		@APIMapping(value="GET_FILE_EXPORT_BY_USER",checkSessionToken=true, checkTrustedApp=true)
		public void downloadPDFFile(@PathVariable(value="fileExportId") Long fileExportId,@PathVariable(value="type") String type,
				HttpServletRequest request, HttpServletResponse response) {
			try {
		        Session session = sessionHelper.getSession(request);
		        String bucketName = session.getAccount().getProjectGroup().getBucketName();
		        FileExport fileExportById = serviceFactory.getFileExportService().getFileExportById(fileExportId);
		        if(fileExportById != null && StringUtils.equals(fileExportById.getProjectGroupCode(), session.getAccount().getProjectGroup().getProjectGroupCode())) {
		        	InputStream inputStream = awsService.downloadFile(bucketName, "Export/"+fileExportId+"."+type, null);
			        response.setContentType("application/zip, application/octet-stream");
			        response.setHeader("Content-Disposition", "attachment; filename="+fileExportId+"."+type); 
			        response.setHeader("x-filename",fileExportId+"."+type); 
			        IOUtils.copy(inputStream, response.getOutputStream());
			        response.flushBuffer();
			        inputStream.close();
		        }else {
		        	throw new AccessDeniedException("The User does not have access to download the report");
		        }
		    } catch (Exception e){
		        logger.debug("Request could not be completed at this moment. Please try again.");
		        e.printStackTrace();
		    }
		}
}
