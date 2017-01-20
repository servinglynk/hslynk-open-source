package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.base.ClientDataElementsEntity;

public class ClientDataElementDaoImpl  extends QueryExecutorImpl implements ClientDataElementDao {

	@Transactional
	public List<ClientDataElementsEntity> getClientDataElements(UUID clientId){
		DetachedCriteria criteria =  DetachedCriteria.forClass(ClientDataElementsEntity.class);
		criteria.add(Restrictions.eq("clientId", clientId));
		return (List<ClientDataElementsEntity>) findByCriteria(criteria);
	}
}