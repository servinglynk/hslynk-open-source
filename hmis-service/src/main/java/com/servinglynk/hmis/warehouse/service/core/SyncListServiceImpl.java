package com.servinglynk.hmis.warehouse.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.live.Sync;
@Service
@Transactional
public class SyncListServiceImpl  extends ParentServiceImpl implements SyncListService  {
	
	@Autowired
	private ParentDaoFactory parentDaoFactory;
	
	public void addSync(Sync sync){
		parentDaoFactory.getSyncListDao().insert(sync);
	}
	public Sync getSync(String id){
		return parentDaoFactory.getSyncListDao().getSync(id);
	}
	public List<Sync> getSyncs(){
		return parentDaoFactory.getSyncListDao().getSyncs();
	}
}
