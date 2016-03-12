package com.servinglynk.hmis.warehouse.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.v2014.HmisUser;
import com.servinglynk.hmis.warehouse.model.v2014.Sync;

@Service
@Transactional
public class HmisUserServiceImpl extends ParentServiceImpl implements HmisUserService {
	
	@Autowired
	private ParentDaoFactory parentDaoFactory;

	@Override
	public void addHmisUser(HmisUser hmisuser) {
		parentDaoFactory.getHmisUserDao().insert(hmisuser);
	}

	@Override
	public HmisUser getHmisUser(String id) {
		return (HmisUser) parentDaoFactory.getHmisUserDao().get(HmisUser.class, id);
	}

	@Override
	public void deleteHmisUser(String id) {
		parentDaoFactory.getHmisUserDao().deleteHmisUser(id);		
	}

	@Override
	public List<HmisUser> getHmisUsers(String id) {
		return parentDaoFactory.getHmisUserDao().getHmisUsers();
	}

	@Override
	public void updateStrategy(HmisUser hmisUser) {
		parentDaoFactory.getHmisUserDao().merge(hmisUser);		
	}
	
	@Override
	public void addSync(Sync sync){
		parentDaoFactory.getSyncListDao().insert(sync);
	}
	@Override
	public Sync getSync(String id){
		return parentDaoFactory.getSyncListDao().getSync(id);
	}
	@Override
	public List<Sync> getSyncs(){
		return parentDaoFactory.getSyncListDao().getSyncs();
	}
}
