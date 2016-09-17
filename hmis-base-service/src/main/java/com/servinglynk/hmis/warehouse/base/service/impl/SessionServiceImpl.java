package com.servinglynk.hmis.warehouse.base.service.impl;


import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_DISABLED;
import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_PENDING;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.SessionService;
import com.servinglynk.hmis.warehouse.base.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.common.util.DateUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidSessionTokenException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.model.base.AccountLockoutEntity;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;
import com.servinglynk.hmis.warehouse.model.base.TrustedAppEntity;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountLockedoutException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AccountPendingException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidAccountCredentialsException;
import com.servinglynk.hmis.warehouse.service.exception.SessionNotFoundException;

public class SessionServiceImpl extends ServiceBase implements SessionService  {
	
	@Autowired  
	protected ValidationBean validationBean;

	@Transactional
	public Session getSession(String userName){
		
	 	com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(userName);
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
		pSession.setAuthCodeExpiresAt(new Date());
		daoFactory.getSessionDao().updateSessionEntity(pSession);
		
	}

	@Transactional
	public void createSession(Session session, String trustedAppId, String auditUser) {
		SessionEntity sessionEntity = new SessionEntity();
		HmisUser pAccount = daoFactory.getAccountDao().findByUsername(session.getAccount().getUsername());
			if(pAccount== null) throw new InvalidSessionTokenException( session.getAccount().getUsername() +" is not a valid account username ");
		
			TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
			if (trustedAppEntity == null || trustedAppEntity.getId() == null)
				throw new InvalidTrustedAppException("invalid trustedAppId: " + trustedAppId);

			sessionEntity.setTrustedApp(trustedAppEntity);
			sessionEntity.setAccount(pAccount);
			sessionEntity.setCreatedBy(auditUser);
			sessionEntity.setCreatedAt(new Date());
			sessionEntity.setSessionToken(SessionEntity.generateSessionToken());
			sessionEntity.setExpiresAt(new Date(System.currentTimeMillis() + (trustedAppEntity.getExpirationTime() * 1000)));
		
		 	daoFactory.getSessionDao().create(sessionEntity);
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
	
	@Transactional
	public void validateUserCredentials(Session session, String trustedAppId, String auditUser ){
		
		if (ValidationUtil.isEmpty(session.getAccount().getPassword())) {
			throw new MissingParameterException("password is required.");
		}

		if (ValidationUtil.isEmpty(session.getAccount().getUsername())) {
			throw new MissingParameterException("username is required.");
		}

		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
		if (trustedAppEntity == null || trustedAppEntity.getId() == null)
			throw new InvalidTrustedAppException("invalid trustedAppId: " + trustedAppId);
		
		HmisUser pAccount = daoFactory.getAccountDao().findByUsername(session.getAccount().getUsername());
		if (pAccount == null ) {
			throw new AccountNotFoundException();
		}

	/*	AccountLockoutEntity pLockout  = null;
		pLockout = pAccount.getAccountLockout();
		if(pLockout!=null) 	validateAccountLockout(pLockout,trustedAppId);*/
		
		if(!pAccount.getPassword().equals(HMISCryptographer.Encrypt(session.getAccount().getPassword()))){
			throw new InvalidAccountCredentialsException();
		} else if (pAccount.getStatus().equals(ACCOUNT_STATUS_DISABLED)) {
			throw new AccountDisabledException();
		} else if (pAccount.getStatus().equals(ACCOUNT_STATUS_PENDING)) {
			throw new AccountPendingException();
		} else if(pAccount.getStatus().equals(Constants.ACCOUNT_STATUS_DELETED)){
			throw new AccessDeniedException("Account is deleted");
		} else if(pAccount.getStatus().equals(Constants.ACCOUNT_STATUS_INACTIVE)){
			throw new AccessDeniedException("Account is inactive");
		}
		

		if(!pAccount.isTwoFactorAuthentication()){
			this.createSession(session, trustedAppId, auditUser);
		}else{
			SessionEntity sessionEntity = new SessionEntity();
			sessionEntity.setTrustedApp(trustedAppEntity);
			sessionEntity.setAccount(pAccount);
			sessionEntity.setCreatedBy(auditUser);
			sessionEntity.setCreatedAt(new Date());
			sessionEntity.setAuthCode(SessionEntity.generateSessionToken());
			sessionEntity.setAuthCodeExpiresAt(new Date(System.currentTimeMillis() + (trustedAppEntity.getExpirationTime() * 1000)));
		
		 	daoFactory.getSessionDao().create(sessionEntity);
		 	session.setAuthCode(sessionEntity.getAuthCode());
			session.setNextAction(Constants.TWO_FACTOR_AUTH_FLOW_OPT);
		}
	}
	
	
/*	@Transactional
	public void createSession(Session session,String auditUser) throws Exception {
		GoogleAuthenticator auth = new GoogleAuthenticator();
		
		SessionEntity sessionEntity = daoFactory.getSessionDao().findByAuthCode(session.getAuthCode());
		if(sessionEntity == null) throw new InvalidSessionTokenException();
		
		HmisUser hmisUser = sessionEntity.getAccount();
		boolean authenticated = auth.authorize(hmisUser.getAuthenticatorSecret(), Integer.parseInt(session.getAccount().getOtp()));
		if(!authenticated){
			throw new InvalidOnetimePasswordException();
		}
		sessionEntity.setSessionToken(SessionEntity.generateSessionToken());
		sessionEntity.setExpiresAt(new Date(System.currentTimeMillis() + (20000 * 1000)));
		
		daoFactory.getSessionDao().updateSessionEntity(sessionEntity);
		session.setToken(sessionEntity.getSessionToken());
	}
*/	
	@Transactional
	public Session validateSession(String sessionToken) {
		SessionEntity sessionEntity = daoFactory.getSessionDao().findBySessionToken(sessionToken);
		if(sessionEntity == null) throw new SessionNotFoundException();
		Session session = new Session();
		session.setExpiresAt(sessionEntity.getExpiresAt());
		return session;
	}
}
