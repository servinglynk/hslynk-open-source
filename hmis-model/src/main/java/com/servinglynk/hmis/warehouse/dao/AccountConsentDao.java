package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.AccountConsentEntity;

public interface AccountConsentDao {

	AccountConsentEntity create(AccountConsentEntity consent);

	AccountConsentEntity findByAccountIdAndTrustedAppId(UUID accountId, UUID trustedAppId);

	AccountConsentEntity updateAccountConsent(AccountConsentEntity consent);

	void deleteAccountConsent(AccountConsentEntity consent);

	AccountConsentEntity findByToken(String consentToken);

	List<AccountConsentEntity> findByAccountIdAndConsented(UUID id, boolean consented);

}
