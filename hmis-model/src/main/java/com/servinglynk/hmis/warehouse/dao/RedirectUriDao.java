package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.RedirectUriEntity;

public interface RedirectUriDao {

	int deleteByTrustedApp(List<RedirectUriEntity> redirectUriEntities);

	RedirectUriEntity create(RedirectUriEntity pRedirectUri);

	RedirectUriEntity findByUriAndTrustedAppId(String redirectUri, UUID id);

}
