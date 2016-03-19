package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.RefreshToken;
import com.servinglynk.hmis.warehouse.model.v2014.SessionEntity;

public class RefreshTokenDaoImpl extends QueryExecutorImpl implements
		RefreshTokenDao {


	public RefreshToken create(RefreshToken refreshToken) {
		insert(refreshToken);
		return refreshToken;
	}

	@SuppressWarnings("unchecked")
	public RefreshToken findByToken(String refreshToken) {
	DetachedCriteria criteria = DetachedCriteria.forClass(RefreshToken.class);
	criteria.add(Restrictions.eq("token",refreshToken));
	
	List<RefreshToken> refreshTokens = (List<RefreshToken>)findByCriteria(criteria);
	if(refreshTokens.size()>0) return refreshTokens.get(0);	
		return null;
	}

	@SuppressWarnings("unchecked")
	public RefreshToken findByAuthCode(String authCode) {
	
		DetachedCriteria criteria = DetachedCriteria.forClass(RefreshToken.class);
		criteria.add(Restrictions.eq("authCode",authCode));
		
		List<RefreshToken> refreshTokens = (List<RefreshToken>)findByCriteria(criteria);
		if(refreshTokens.size()>0) return refreshTokens.get(0);	
			return null;
	}


	public void deleteRefreshToken(RefreshToken pRefreshToken) {
		update(pRefreshToken);
		
	}

	public RefreshToken updateRefreshToken(RefreshToken pRefreshToken) {
		update(pRefreshToken);
		return pRefreshToken;
	}

	@SuppressWarnings("unchecked")
	public int deleteByTrustedAppIdAndAccountId(UUID trustedAppId,
			UUID accountId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefreshToken.class);
		criteria.createAlias("account","account");
		criteria.createAlias("trustedApp","trustedApp");
		criteria.add(Restrictions.eq("trustedApp.id",trustedAppId));
		criteria.add(Restrictions.eq("account.id",accountId));
		int i=0;
		List<SessionEntity> sessions = (List<SessionEntity>)findByCriteria(criteria);
		for(SessionEntity sessionEntity : sessions){
			delete(sessionEntity);
			i++;
		}
		
		return i;
	}

	@SuppressWarnings("unchecked")
	public List<RefreshToken> findByAccountId(UUID  id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefreshToken.class);
		criteria.createAlias("account","account");
		criteria.add(Restrictions.eq("account.id",id));
		
		return (List<RefreshToken>) findByCriteria(criteria);
	}

	
	
	
	
}
