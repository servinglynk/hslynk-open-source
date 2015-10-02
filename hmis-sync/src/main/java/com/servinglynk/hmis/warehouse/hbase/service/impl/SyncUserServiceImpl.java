package com.servinglynk.hmis.warehouse.hbase.service.impl;

import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.hbase.service.SyncUserService;
import com.servinglynk.hmis.warehouse.sync.hbase.model.HmisUser;

@Service
public class SyncUserServiceImpl implements SyncUserService {

//	@Autowired
//	private SyncUserDao syncUserDao;
//	
//	@Autowired
//	private SyncListDao syncListDao;
	
	public boolean syncHmisUser(List<HmisUser> hmisUsers) {
//		Sync sync = new Sync();
//		sync.setSyncTable("hmis_user");
//		sync.setStatus("INPROGRESS");
//		sync.setDateCreated(LocalDate.now());
//		sync.setDateUpdated(LocalDate.now());
//		Sync insertedSync = null;

		return true;
	}
	public List<HmisUser> getHmisUser(String rowKey){
		HmisUser user = new HmisUser();
		user.setId(rowKey);
		try {
//			return syncUserDao.get(user);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
