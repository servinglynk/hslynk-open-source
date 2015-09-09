package com.servinglynk.hmis.warehouse.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.hbase.model.HmisUser.Personal;
import com.servinglynk.hmis.warehouse.hbase.model.HmisUser.Professional;
import com.servinglynk.hmis.warehouse.hbase.service.SyncUserService;
import com.servinglynk.hmis.warehouse.model.HmisUser;
import com.servinglynk.hmis.warehouse.model.Sync;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;

@RestController
public class HmisUserController {

	@Autowired
	@Qualifier("serviceFactory")
	private ParentServiceFactory parentServiceFactory;
	
	@Autowired
	private SyncUserService syncService;
	
    private final org.slf4j.Logger log = LoggerFactory.getLogger(HmisUserController.class);
    
	  @RequestMapping(value = "/table/{tableName}",
	            method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    List<com.servinglynk.hmis.warehouse.hbase.model.HmisUser> getUser(@PathVariable String tableName) {
	        log.debug("REST request to get User : {}", tableName);
	        //TODO : Get all the hmisuser tables.
	        
	        List<HmisUser> hmisUsers = parentServiceFactory.getHmisUserService().getHmisUsers("123");
	        //TODO Convert HmisUser to Hbase's HMISUser.
	        List<com.servinglynk.hmis.warehouse.hbase.model.HmisUser> hbaseUsers = new ArrayList<>();
	        for(HmisUser user : hmisUsers)
	        {
	        	com.servinglynk.hmis.warehouse.hbase.model.HmisUser hbaseUser = new com.servinglynk.hmis.warehouse.hbase.model.HmisUser();
	        	hbaseUser.setId(user.getId().toString());
	        	Personal personal = hbaseUser.new Personal();
	        	personal.setFirstName(user.getFirstName());
	        	personal.setLastName(user.getLastName());
	        	//personal.setDob(new Date(String.valueOf(user.getDob())));
	        	personal.setGender(user.getGender().getValue());
	        	personal.setSsn(user.getSsn());
	    		Professional professional = hbaseUser.new Professional();
	    		professional.setOrganization("abc");
	        	hbaseUser.setPersonal(personal);
	        	hbaseUsers.add(hbaseUser);
	        }
	      
	        syncService.syncHmisUser(hbaseUsers);
	    	
	        Sync sync = new Sync();
			sync.setSyncTable("hmis_user");
			sync.setStatus("COMPLETE");
			sync.setDateCreated(LocalDate.now());
			sync.setDateUpdated(LocalDate.now());
			Sync insertedSync = null;
			parentServiceFactory.getSyncListService().addSync(sync);
	        return hbaseUsers;
//	        return userRepository.findOneByLogin(login)
//	                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	  
	  @RequestMapping(value = "/table/get/{tableName}/{rowKey}",
	            method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    List<com.servinglynk.hmis.warehouse.hbase.model.HmisUser> getUser(@PathVariable String tableName, @PathVariable String rowKey) {
	        log.debug("REST request to get User : {}", tableName);
	        //TODO : Get all the hmisuser tables.
	        return syncService.getHmisUser(rowKey);
//	        return userRepository.findOneByLogin(login)
//	                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

}
