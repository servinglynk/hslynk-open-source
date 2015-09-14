package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.SessionEntity;

public interface SessionDao {

	SessionEntity create(SessionEntity accessToken);

	int deleteByRefreshTokenId(UUID id);

	SessionEntity findByAuthCode(String authCode);

	void deleteSession(SessionEntity pToken);

	SessionEntity findBySessionToken(String refreshToken);

	int deleteByTrustedAppIdAndAccountId(UUID  trustedAppId, UUID accountId);

	SessionEntity updateSessionEntity(SessionEntity pSession);

	SessionEntity findBySessionTokenForInterceptor(String accessToken);

	List<SessionEntity> findDirectAccessTokensByAccountId(UUID id);

}
