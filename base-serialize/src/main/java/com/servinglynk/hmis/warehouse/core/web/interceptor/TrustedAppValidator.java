package com.servinglynk.hmis.warehouse.core.web.interceptor;

import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;

public interface TrustedAppValidator {


	public TrustedApp validateTrustedAppId(String trustedAppId) throws InvalidTrustedAppException;

}