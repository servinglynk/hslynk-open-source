package com.servinglynk.hmis.warehouse.rest;import javax.servlet.http.Cookie;import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import com.servinglynk.hmis.warehouse.base.service.SessionService;import com.servinglynk.hmis.warehouse.core.model.Session;/** * Provides the following functionality / features: *  * <li>Retrieve the session token from HTTP request and validate it. <li>Get and * set {@link Session} into HTTP request as an attribute upon successful * validation of the session token. *  * @author Sandeep Dolia */public class SessionHelper {	/**	 * Name of the header used to get the session-token from the request	 */	private String headerName = "Authorization";	/**	 * Name of the query parameter used to get the session-token from the	 * request	 */	private String parameterName = "sessionToken";	/**	 * Name of the Cookie used to get the session-token from the request	 */	private String cookieName = "session_token";	/**	 * The regular expression used to split the header value to extract the	 * session-token	 */	private String headerRegex = "[\\s|=|\"]+";	/**	 * Name of the authentication realm	 */	private String authRealm = "HMISUserAuth";	/**	 * Name of the authentication realm for OAuth	 */	private String oAuthRealm = "Bearer";	/**	 * {@link Enum} describing supported methods to specify the session token in	 * the request	 */	private static enum Method {		Query, Header, Cookie	};	/**	 * The order of {@link Method}s to use when obtaining session token from the	 * request	 */	private Method[] methodOrder = new Method[] { Method.Query, Method.Header, Method.Cookie };	/**	 * Key to use when storing/retrieving {@link Session} in the	 * {@link HttpServletRequest}	 */	private String requestAttributeName = "com.servinglynk.hmis.warehouse.core.model.Session";//	private SessionValidator sessionValidator;	public Session getSession(HttpServletRequest request) {		String sessionToken = request.getHeader("Authorization");				return	sessionService.getSession(sessionToken);	}	public void setSession(Session session, HttpServletRequest request) {		request.setAttribute(requestAttributeName, session);	}/*	public void validateSessionToken(HttpServletRequest request) throws InvalidSessionTokenException {		String sessionToken = retrieveSessionToken(request);		Session session = sessionValidator.validateSessionToken(sessionToken);		setSession(session, request);	}*/	public String retrieveSessionToken(HttpServletRequest request) {		String sessionToken = null;		for (Method method : methodOrder) {			sessionToken = retrieveSessionToken(request, method);			if (sessionToken != null) {				break;			}		}		return sessionToken;	}	private String retrieveSessionToken(HttpServletRequest request, Method method) {		String sessionToken = null;		switch (method) {		case Header:			String headerValue = request.getHeader(headerName);			if (headerValue != null) {				String[] split = headerValue.split(headerRegex);				if (split != null)	{					if ((split.length >= 3) && split[0].equalsIgnoreCase(authRealm))	{						sessionToken = split[2];					}					else if ((split.length >= 2) && split[0].equalsIgnoreCase(oAuthRealm))	{						sessionToken = split[1];					}				}			}			break;		case Query:			sessionToken = request.getParameter(parameterName);			break;		case Cookie:			Cookie[] cookies = request.getCookies();			if (cookies != null) {				for (Cookie cookie : cookies) {					if (cookie.getName().equals(cookieName)) {						sessionToken = cookie.getValue();					}				}			}			break;		}		return sessionToken;	}	public String getHeaderName() {		return headerName;	}	public void setHeaderName(String headerName) {		this.headerName = headerName;	}	public String getParameterName() {		return parameterName;	}	public void setParameterName(String parameterName) {		this.parameterName = parameterName;	}	public String getCookieName() {		return cookieName;	}	public void setCookieName(String cookieName) {		this.cookieName = cookieName;	}	public String getHeaderRegex() {		return headerRegex;	}	public void setHeaderRegex(String headerRegex) {		this.headerRegex = headerRegex;	}	public String getAuthRealm() {		return authRealm;	}	public void setAuthRealm(String authRealm) {		this.authRealm = authRealm;	}	public String getOAuthRealm() {		return oAuthRealm;	}	public void setOAuthRealm(String oAuthRealm) {		this.oAuthRealm = oAuthRealm;	}	public Method[] getMethodOrder() {		return methodOrder;	}	public void setMethodOrder(Method[] methodOrder) {		this.methodOrder = methodOrder;	}	public String getRequestAttributeName() {		return requestAttributeName;	}	public void setRequestAttributeName(String requestAttributeName) {		this.requestAttributeName = requestAttributeName;	}/*	public SessionValidator getSessionValidator() {		return sessionValidator;	}	public void setSessionValidator(SessionValidator sessionValidator) {		this.sessionValidator = sessionValidator;	}	*/		@Autowired	SessionService sessionService;		public Session getSession(){			return	sessionService.getSession("");			}	}