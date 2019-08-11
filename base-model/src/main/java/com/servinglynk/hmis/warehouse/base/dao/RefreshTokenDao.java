package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.RefreshToken;

public interface RefreshTokenDao {

	RefreshToken create(RefreshToken refreshToken);

	RefreshToken findByToken(String refreshToken);

	RefreshToken findByAuthCode(String authCode);

	void deleteRefreshToken(RefreshToken pRefreshToken);

	RefreshToken updateRefreshToken(RefreshToken pRefreshToken);

	int deleteByTrustedAppIdAndAccountId(UUID trustedAppId, UUID accountId);

	List<RefreshToken> findByAccountId(UUID id);

}
