package com.servinglynk.hmis.warehouse.service.impl;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.util.DateUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidSessionTokenException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.model.live.AccountLockoutEntity;
import com.servinglynk.hmis.warehouse.model.live.SessionEntity;
import com.servinglynk.hmis.warehouse.model.live.TrustedAppEntity;
import com.servinglynk.hmis.warehouse.service.SessionService;
import com.servinglynk.hmis.warehouse.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.service.exception.AccountLockedoutException;
import com.servinglynk.hmis.warehouse.service.exception.SessionNotFoundException;

public class SessionServiceImpl extends ServiceBase implements SessionService  {
	
	@Autowired  
	protected ValidationBean validationBean;

	@Transactional
	public Session getSession(String userName){
		
	 	com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(userName);
		if(pAccount== null) throw new InvalidSessionTokenException( userName +" is not a valid account username ");
		Account account = AccountConverter.convertToAccount(pAccount);
		Session session = new Session();
		session.setAccount(account);;
		return session;
	}

	
	public Session validateSessionToken(String authenticationToken) {
		SessionEntity pSession = daoFactory.getSessionDao().findBySessionToken(authenticationToken);
		if (pSession == null) {
			throw new InvalidSessionTokenException("invalid session token: " + authenticationToken);
		}

		if (pSession.getExpiresAt().before(new Date())){
            throw new InvalidSessionTokenException("token has expired: " + authenticationToken);
		}
		
		Session session = new Session();
		session.setToken(authenticationToken);

		Account account = AccountConverter.convertToAccount(pSession.getAccount());
		session.setAccount(account);

		return session;
	}

	
	@Transactional
	public void endSession(String sessionToken) {
		SessionEntity pSession = daoFactory.getSessionDao().findBySessionToken(sessionToken);
		if (pSession == null) {
			throw new SessionNotFoundException("session not found. token: " + sessionToken);
		}
		
		if (pSession.getExpiresAt().before(new Date())) {
			throw new InvalidSessionTokenException("invalid session token: " + sessionToken);
		}
		
		pSession.setExpiresAt(new Date());
		daoFactory.getSessionDao().updateSessionEntity(pSession);
		
	}

	@Transactional
	public void createSession(Session session, String trustedAppId, String auditUser) {
		SessionEntity sessionEntity = new SessionEntity();
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(session.getAccount().getUsername());
			if(pAccount== null) throw new InvalidSessionTokenException( session.getAccount().getUsername() +" is not a valid account username ");
		
			TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
			if (trustedAppEntity == null || trustedAppEntity.getId() == null)
				throw new InvalidTrustedAppException("invalid trustedAppId: " + trustedAppId);

			sessionEntity.setTrustedApp(trustedAppEntity);

			
			
			sessionEntity.setAccount(pAccount);
			sessionEntity.setCreatedBy(auditUser);
			sessionEntity.setCreatedAt(new Date());
			sessionEntity.setSessionToken(SessionEntity.generateSessionToken());
			sessionEntity.setExpiresAt(new Date(System.currentTimeMillis() + (20000 * 1000)));
		
		 	daoFactory.getSessionDao().create(sessionEntity);
		 	//session.getAccount().setOrganizationId(pAccount.getOrganization().getId());
		 	session.setToken(sessionEntity.getSessionToken());
			
	}
	
	@SuppressWarnings("unused")
	private AccountLockoutEntity setAccountLockout(AccountLockoutEntity pLockout){
		pLockout.setFailureCount(0);
		pLockout.setLastLoginStatus(1); // login status 0 indicates failure attempt , 1 indicates successful attempt
		pLockout.setLastAttemptAt(Calendar.getInstance().getTime());
		pLockout.setModifiedAt(Calendar.getInstance().getTime());
		return pLockout;
}
	
	
	
	@SuppressWarnings("unused")
	private void validateAccountLockout(AccountLockoutEntity pLockout,String trustedAppId) {
		int failureCount =0;
		if(pLockout.getLastLoginStatus()==0){
				if(!exceededLockoutTime(pLockout))  failureCount = pLockout.getFailureCount();
		}
		if(checkMaxAttempts(failureCount))
			throw new AccountLockedoutException("Your AccountEntity is Locked, Please try after lock out time", validationBean.getLockoutMinutes());
		
		
   }
	
	
	private boolean checkMaxAttempts(int failureCount){
        return failureCount == validationBean.getMaxPwattempts();
    }
	
	private boolean exceededLockoutTime(AccountLockoutEntity pLockout){
		if(pLockout.getLastAttemptAt()!=null){
			long hoursSinceLastFailureAttempt = DateUtil.diffinMinutes(Calendar.getInstance().getTime(),pLockout.getLastAttemptAt());
			if(ValidationUtil.isNotEmpty(validationBean.getLockoutMinutes())){ //TODO - property lockoutHours in validation bean should be changed to lockutMinutes 
				Integer lockoutTime = Integer.parseInt(validationBean.getLockoutMinutes());
				if(hoursSinceLastFailureAttempt < lockoutTime) return false;
			}
		}
		return true;
	}
	
}
