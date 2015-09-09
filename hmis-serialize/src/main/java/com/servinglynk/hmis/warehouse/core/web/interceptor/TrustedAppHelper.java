package com.servinglynk.hmis.warehouse.core.web.interceptor;


import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import javax.servlet.http.HttpServletRequest;


public class TrustedAppHelper {

	/**
	 * Name of the header used to get the trustedApp-id from the request
	 */
	private String headerName = Constants.TRUSTEDAPP_HEADER;

	/**
	 * Name of the query parameter used to get the trustedApp_id from the
	 * request
	 */
	private String parameterName = "trustedApp_id";

	/**
	 * {@link Enum} describing supported methods to specify the trustedApp_id
	 * in the request
	 */
	private static enum Method {
		Query, Header
	};


	private Method[] methodOrder = new Method[] { Method.Query, Method.Header };


	private String requestAttributeName = "com.hmis.core.model.TrustedApp";

	private TrustedAppValidator trustedAppValidator;

	public TrustedApp getTrustedApp(HttpServletRequest request) {
		return (TrustedApp) request.getAttribute(requestAttributeName);
	}

	public void setTrustedApp(TrustedApp trustedApp, HttpServletRequest request) {
		request.setAttribute(requestAttributeName, trustedApp);
	}

	public void validateTrustedAppId(HttpServletRequest request) throws InvalidTrustedAppException {
		String trustedAppId = retrieveTrustedAppId(request);
		TrustedApp trustedApp = trustedAppValidator.validateTrustedAppId(trustedAppId);
		setTrustedApp(trustedApp, request);
	}

	public String retrieveTrustedAppId(HttpServletRequest request) {
		String trustedAppId = null;
		for (Method method : methodOrder) {
			trustedAppId = retrieveTrustedApp(request, method);
			if (trustedAppId != null) {
				break;
			}
		}
		return trustedAppId;
	}

	private String retrieveTrustedApp(HttpServletRequest request, Method method) {
		String trustedAppId = null;
		switch (method) {
		case Header:
			trustedAppId = request.getHeader(headerName);
			break;
		case Query:
			trustedAppId = request.getParameter(parameterName);
			break;
		}
		if (trustedAppId != null) {
			trustedAppId = trustedAppId.trim();
		}
		return trustedAppId;
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public Method[] getMethodOrder() {
		return methodOrder;
	}

	public void setMethodOrder(Method[] methodOrder) {
		this.methodOrder = methodOrder;
	}

	public String getRequestAttributeName() {
		return requestAttributeName;
	}

	public void setRequestAttributeName(String requestAttributeName) {
		this.requestAttributeName = requestAttributeName;
	}

	public TrustedAppValidator getTrustedAppValidator() {
		return trustedAppValidator;
	}

	public void setTrustedAppValidator(TrustedAppValidator trustedAppValidator) {
		this.trustedAppValidator = trustedAppValidator;
	}

}