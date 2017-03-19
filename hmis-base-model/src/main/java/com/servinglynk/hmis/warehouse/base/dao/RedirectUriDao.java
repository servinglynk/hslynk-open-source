package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.RedirectUriEntity;

public interface RedirectUriDao {

	int deleteByTrustedApp(List<RedirectUriEntity> redirectUriEntities);

	RedirectUriEntity create(RedirectUriEntity pRedirectUri);

	RedirectUriEntity findByUriAndTrustedAppId(String redirectUri, UUID id);

}
