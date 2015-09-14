package com.servinglynk.hmis.warehouse.sync.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.sync.business.service.core.SyncParentService;
import com.servinglynk.hmis.warehouse.sync.business.util.SyncStatus;


@Service
public class SyncService extends SyncParentService implements ISyncService {

	public void createSyncInit() {
		try{
			Sync syncNew = new Sync();
			syncNew.setStatus("INITIAL");
			syncNew.setDateCreated(LocalDate.now());
			syncNew.setDateUpdated(LocalDate.now());
			daoFactory.getSyncListDao().insert(syncNew);
		}catch(Exception e) {
			
		}
	}

	@Override
	public Sync performSync() throws Exception {
		try{

			/***
			 * Now get the last successful sync date and perform Sync from there. 
			 */
			Sync lastSync =  daoFactory.getSyncListDao().findLastSync(SyncStatus.COMPLETE.getStatus());
			if(lastSync !=null) {
				/**
				 * Perform Sync for each and every Entity.
				 */
				createSyncInit();
				
			// Sync HMIS_USER
				
		    // Sync Client and Veteran Info
		
			// Sync Enrollment and all its dependent items
		
			// Sync Project with Enrollment
				
			// Sync Exit tables.
				
			// Sync User roles and permissions.
				
			}
		}catch(Exception e){
		}
		return null;
		}
	
}
