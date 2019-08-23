package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;

public class ClientMetaDataDaoImpl extends QueryExecutorImpl implements ClientMetaDataDao {

	@Override
	public List<ClientMetaDataEntity> findClientMetaData(UUID clientDedupClientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientMetaDataEntity.class);
		criteria.add(Restrictions.eq("clientDedupId", clientDedupClientId));
		criteria.add(Restrictions.eq("deleted", false));
		return (List<ClientMetaDataEntity>) findByCriteria(criteria);
	}

	@Override
	public void createClientMetaData(ClientMetaDataEntity metaDataEntity) {
			insert(metaDataEntity);		
	}

	@Override
	public void updateClientMetaData(ClientMetaDataEntity metaDataEntity) {
		update(metaDataEntity);
	}

	@Override
	public ClientMetaDataEntity findByIdentifier(UUID identifier) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientMetaDataEntity.class);
		criteria.add(Restrictions.eq("metaDataIdentifier", identifier));
		criteria.add(Restrictions.eq("deleted", false));
		List<ClientMetaDataEntity> entities = (List<ClientMetaDataEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}

}
