package com.servinglynk.hmis.warehouse.rest.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.core.model.OAuthError;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.service.exception.AccountConsentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeAlreadyUsedException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeExpiredException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.GrantTypeNotSupportedException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRedirectUriException;
import com.servinglynk.hmis.warehouse.service.exception.RefreshTokenNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SessionNotFoundException;


public class OAuthExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// Surya Yadavalli - 06.02.2015 - Exception handling codes for OAUTH errors

	public static final String ERR_CODE_SERVER_ERROR           = "server_error";
	public static final String ERR_CODE_INVALID_REQUEST        = "invalid_request";
	public static final String ERR_CODE_INVALID_GRANT          = "invalid_grant";
	public static final String ERR_CODE_ACCESS_DENIED          = "access_denied";
	public static final String ERR_CODE_UNAUTHORIZED_TRUSTEDAPP    = "unauthorized_trustedApp";
	public static final String ERR_CODE_UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type";
	
	// query parameter names
	public static final String PARAM_NAME_SC_200_ONLY = "sc200Only";
	
	private boolean internalErrorMessageReturned;

	@SuppressWarnings("static-access")
	public Result map(Throwable th, HttpServletRequest request) {

		Result r = new Result();

		try {
			
			throw th;

		} catch (InvalidParameterException ex) {

			logger.info("InvalidParameterException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_REQUEST);
			r.setErrorMessage(ex.getMessage());

		} catch (MissingParameterException ex) {

			logger.info("MissingParameterException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_REQUEST);
			r.setErrorMessage(ex.getMessage());

		} catch (AuthCodeAlreadyUsedException ex) {

			logger.info("AuthCodeAlreadyUsedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_GRANT);
			r.setErrorMessage(ex.getMessage());

		} catch (AuthCodeExpiredException ex) {

			logger.info("AuthCodeAlreadyUsedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_GRANT);
			r.setErrorMessage(ex.getMessage());

		} catch (AuthCodeNotFoundException ex) {

			logger.info("AuthCodeNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_GRANT);
			r.setErrorMessage(ex.getMessage());

		} catch (AccessDeniedException ex) {

			logger.info("AccessDeniedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_ACCESS_DENIED);
			r.setErrorMessage(ex.getMessage());

		} catch (RefreshTokenNotFoundException ex) {

			logger.info("RefreshTokenNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ex.getContext().equals(ex.REVOCATION) ? ERR_CODE_INVALID_REQUEST : ERR_CODE_INVALID_GRANT);
			r.setErrorMessage(ex.getMessage());

		}  catch (GrantTypeNotSupportedException ex) {

			logger.info("GrantTypeNotSupportedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_UNAUTHORIZED_TRUSTEDAPP);
			r.setErrorMessage(ex.getMessage());

		}catch (InvalidRedirectUriException ex) {

			logger.info("InvalidRedirectUriException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_REQUEST);
			r.setErrorMessage(ex.getMessage());

		} catch (SessionNotFoundException ex) {

			logger.info("SessionNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_REQUEST);
			r.setErrorMessage(ex.getMessage());

		}  catch (AccountConsentNotFoundException ex) {

			logger.info("AccountConstentNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_REQUEST);
			r.setErrorMessage(ex.getMessage());

		} catch (AccountDisabledException ex) {

			logger.info("AccountDisabledException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_GRANT);
			r.setErrorMessage(ex.getMessage());

		} /*catch (AccountPendingException ex) {

			logger.info("AccountPendingException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_GRANT);
			r.setErrorMessage(ex.getMessage());

		} */catch (Throwable t) {
        	
			logger.error(t.getMessage(), t);

			if (t.getCause() != null)	{
				if (t.getCause().getClass().getName().endsWith("UnmarshallingFailureException"))	{
					r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
					r.setErrorCode(ERR_CODE_INVALID_REQUEST);
					r.setErrorMessage("Invalid payload");
				}
        	}
        	else	{
				r.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				r.setErrorCode(ERR_CODE_SERVER_ERROR);
				if (isInternalErrorMessageReturned()) {
					r.setErrorMessage(ERR_CODE_SERVER_ERROR + " : " + t.getMessage());
				} else {
					r.setErrorMessage(ERR_CODE_SERVER_ERROR);
				}
        	}
		}

		if (returnStatusCode200Only(request)) {
			r.setStatusCode(HttpServletResponse.SC_OK);
		}

		return r;
	}


	@SuppressWarnings("rawtypes")
	private boolean returnStatusCode200Only(HttpServletRequest request) {
		boolean sc200Only = false;
		Map parameterMap = request.getParameterMap();
		if (parameterMap != null) {
			sc200Only = parameterMap.keySet().contains(PARAM_NAME_SC_200_ONLY);
		}

		return sc200Only;
	}
	
	public boolean isInternalErrorMessageReturned() {
		return internalErrorMessageReturned;
	}

	public void setInternalErrorMessageReturned(boolean internalErrorMessageReturned) {
		this.internalErrorMessageReturned = internalErrorMessageReturned;
	}

	

	public static class Result {

		private int statusCode;
		private OAuthError error = new OAuthError();

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public OAuthError getError() {
			return error;
		}

		public void setErrorCode(String errorCode) {
			this.error.setError(errorCode);
		}

		public void setErrorMessage(String errorMessage) {
			this.error.setErrorDescription(errorMessage);
		}
	}
}
