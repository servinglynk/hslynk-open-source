package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentServiceFactory;
@RestController
@RequestMapping("/bulkupload")
public class BulkUploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(BulkUploadController.class);
	 @Autowired
		protected ParentServiceFactory parentServiceFactory;
	 
	 /**
		 * Upload single file using Spring Controller
		 */
	 	@RequestMapping(method = RequestMethod.GET)
		public @ResponseBody
		List<BulkUploadDTO> getBulkUploadedFiles(@RequestParam(value ="status", required = false) String status) {

	 		try {
	 			List<BulkUpload> uploads = parentServiceFactory.getBulkUploadService().getBulkUploads(status);
	 			List<BulkUploadDTO> dtos = new ArrayList<BulkUploadDTO>();
	 			if(uploads !=null) {
	 				for(BulkUpload upload : uploads) {
	 					BulkUploadDTO dto = new BulkUploadDTO();
	 					BeanUtils.copyProperties(upload, dto, new String[] {"export"});
	 					dtos.add(dto);
	 				}
	 			}
	 			return dtos;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		return null;
		}

}
