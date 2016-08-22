package com.servinglynk.hmis.household.web.rest.util;


import javax.servlet.http.HttpServletRequest;


public class TrustedAppHelper {

	/**
	 * Name of the header used to get the trustedApp-id from the request
	 */
	private String headerName = "X-HMIS-TrustedApp-Id";

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

}