package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Client;
import com.servinglynk.hmis.warehouse.model.v2014.HmisUser;

public class HmisUserDaoImpl extends ParentDaoImpl implements HmisUserDao {

	@Override
	public void addHmisUser(HmisUser hmisUser) {
		insert(hmisUser);
	}
	@Override
	public void addClient(Client client) {
		insert(client);
	}
	@Override
	public HmisUser getHmisUser(String id) {
		HmisUser hmisUser = (HmisUser) get(HmisUser.class, id);
		return hmisUser;
	}
	
	public HmisUser getHmisUser(UUID id) {
		HmisUser hmisUser = (HmisUser) get(HmisUser.class, id);
		return hmisUser;
	}

	@Override
	public void updateHmisUser(HmisUser hmisUser) {
		HmisUser hmisUserToUpdate = getHmisUser(hmisUser.getId().toString());
		hmisUserToUpdate.setFirstName(hmisUser.getFirstName());
		update(hmisUserToUpdate);
	}

	@Override
	public void deleteHmisUser(String id) {
		HmisUser hmisUser = getHmisUser(id);
		if (hmisUser != null)
			delete(hmisUser);
	}

	@Override
	public List<HmisUser> getHmisUsers() {
		return (List<HmisUser>) list("HmisUser");
	}
	
	public HmisUser findByUsername(String userName){
		DetachedCriteria criteria= DetachedCriteria.forClass(HmisUser.class);
		criteria.add(Restrictions.eq("username",userName));
		List<HmisUser> accountEntities = (List<HmisUser>)findByCriteria(criteria);
		if(accountEntities.size()>0){
			return getHmisUser(accountEntities.get(0).getId());
		}
		return null;
	}
	
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hydrateLive(Export export) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
