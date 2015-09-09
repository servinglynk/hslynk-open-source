package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.entity.RedirectUriEntity;

public class RedirectUriDaoImpl extends QueryExecutorImpl implements
		RedirectUriDao {

	@Override
	public int deleteByTrustedApp(List<RedirectUriEntity> redirectUriEntities) {
		for(RedirectUriEntity redirectUriEntity : redirectUriEntities)
			delete(redirectUriEntity);
		return redirectUriEntities.size();
	}


	@Override
	public RedirectUriEntity create(RedirectUriEntity pRedirectUri) {
		insert(pRedirectUri);
		return null;
	}


	@SuppressWarnings("unchecked")
	public RedirectUriEntity findByUriAndTrustedAppId(String redirectUri,
			UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RedirectUriEntity.class);
		criteria.createAlias("trustedApp", "trustedApp");
		criteria.add(Restrictions.eq("trustedApp.id", id));
		criteria.add(Restrictions.eq("uri", redirectUri));
		List<RedirectUriEntity> uris = (List<RedirectUriEntity>) findByCriteria(criteria);
		if(uris.size()>0) return uris.get(0);
		return null;
	}
}
