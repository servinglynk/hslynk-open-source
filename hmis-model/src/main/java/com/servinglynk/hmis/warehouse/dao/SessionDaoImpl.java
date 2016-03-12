package com.servinglynk.hmis.warehouse.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.RefreshToken;
import com.servinglynk.hmis.warehouse.model.v2014.SessionEntity;

public class SessionDaoImpl extends QueryExecutorImpl implements
		SessionDao {


	public SessionEntity create(SessionEntity accessToken) {
			insert(accessToken);
		return accessToken;
	}

	public int deleteByRefreshTokenId(UUID id) {
		RefreshToken refreshToken =	(RefreshToken) get(RefreshToken.class, id);
		delete(refreshToken);
		return 0;
	}

	@SuppressWarnings("unchecked")
	public SessionEntity findByAuthCode(String authCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SessionEntity.class);
		criteria.add(Restrictions.eq("authCode",authCode));
		
		List<SessionEntity> sessions = (List<SessionEntity>) findByCriteria(criteria);
		if(sessions.size()>0) return sessions.get(0);
		return null;
	}


	public void deleteSession(SessionEntity pToken) {
		update(pToken);
	}

	@SuppressWarnings("unchecked")
	public SessionEntity findBySessionToken(String sessionToken) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SessionEntity.class);
		
		criteria.add(Restrictions.eq("sessionToken",sessionToken));
		List<SessionEntity> sessions = (List<SessionEntity>)findByCriteria(criteria);
		if(sessions.size()>0) return sessions.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public int deleteByTrustedAppIdAndAccountId(UUID trustedAppId,
			UUID accountId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SessionEntity.class);
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


	public SessionEntity updateSessionEntity(SessionEntity pSession) {
			update(pSession);
		return pSession;
	}

	@SuppressWarnings("unchecked")
	public SessionEntity findBySessionTokenForInterceptor(String accessToken) {
		DetachedCriteria criteria= DetachedCriteria.forClass(SessionEntity.class);
		criteria.add(Restrictions.eq("sessionToken",accessToken));
		List<SessionEntity> sessions = (List<SessionEntity>)findByCriteria(criteria);
		if(sessions.size()>0) return sessions.get(0);
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SessionEntity> findDirectAccessTokensByAccountId(UUID id) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(SessionEntity.class);
		criteria.add(Restrictions.eq("id",id));
		criteria.add(Restrictions.eq("refreshToken",null));
		criteria.add(Restrictions.ge("expiresAt", new Date()));

		return (List<SessionEntity>)findByCriteria(criteria);
	}

}
