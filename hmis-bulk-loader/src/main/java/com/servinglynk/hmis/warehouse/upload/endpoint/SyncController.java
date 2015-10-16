package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentServiceFactory;

@RestController
@RequestMapping("/sync")
public class SyncController {
	private static final Logger logger = LoggerFactory
			.getLogger(SyncController.class);
	 @Autowired
    protected ParentServiceFactory parentServiceFactory;
	 
	public List<Sync> listOfSyncs() {
		return parentServiceFactory.getBulkUploadService().getSyncs();
	}
}
