package com.servinglynk.hmis.warehouse.base.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.AccountDataChangeEntity;

public interface AccountDataChangeDao {

	AccountDataChangeEntity create(AccountDataChangeEntity accountDataChange);

	AccountDataChangeEntity getAccountDataChangeByVerificationId(UUID id);

}
