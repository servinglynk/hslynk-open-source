package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.AccountDataChangeEntity;

public interface AccountDataChangeDao {

	AccountDataChangeEntity create(AccountDataChangeEntity accountDataChange);

	AccountDataChangeEntity getAccountDataChangeByVerificationId(UUID id);

}
