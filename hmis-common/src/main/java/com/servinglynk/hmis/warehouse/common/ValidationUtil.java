package com.servinglynk.hmis.warehouse.common;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.InetAddressValidator;


public final class ValidationUtil {
	private static final String ALPHA_NUMERIC = "^([A-Za-z0-9]*)$";

	
	public static boolean isNotEmpty(String str) {
		//return (str != null && (!str.trim().isEmpty()));
		return !isEmpty(str);
	}
	public static boolean isEmpty(String str) {
		//return (str == null || str.trim().isEmpty());
		return GenericValidator.isBlankOrNull(str);
	}
	/*
	public static boolean isValidString(String value,String expression){
		if(!isEmpty(value))
		return !GenericValidator.matchRegexp(value,expression);
		return true;
	}
	*/
	public static boolean isNotNull(Object str) {
		return (str != null);
	}

	public static boolean isNull(Object str) {
		return (str == null);
	}
	

	
	public static boolean isValidPassword(String value){
		if(value!=null) 	return GenericValidator.matchRegexp(value, ALPHA_NUMERIC);
		return true;
	}
	
	public static boolean isValidBoolean(String newsOptInValue) {
		try{
				if(newsOptInValue!=null)
					if(newsOptInValue.equalsIgnoreCase("true") || newsOptInValue.equalsIgnoreCase("false")) return true;
		}catch(Exception e){
				return false;
		}
		return false;
	}

	public static boolean isValidMaxLen(String value,Integer max){
		if(value!=null && max!=null) return GenericValidator.maxLength(value, (int)max); 
		return true;
	}
	public static boolean isValidMinLen(String value,Integer min){
		if(value !=null  && min!=null) return GenericValidator.minLength(value, (int)min); 
		return true;
	}
	
	
	public static boolean isValidLen(String value,Integer min,Integer max){
		return isValidMaxLen(value,max) && isValidMinLen(value,min);
	}
	
	public static boolean isValidLocale(Locale localValue){
		java.util.Locale []locales = Locale.getAvailableLocales();   
		for (Locale l : locales)    
				if (localValue.toString().equals(l.toString())) return true;
		
		// if its not a valid locale , check if the language is valid 
		//TODO - see if the below itself will be sufficient to check the validity
		String langValue = localValue.getLanguage();
		boolean isValidLanguage = false;
		if(isEmpty(langValue)) return false;
		String[] languages = Locale.getISOLanguages();
		for(String language: languages) {
			 if(langValue.equalsIgnoreCase(language)){
				 isValidLanguage = true;
				 break;
			 }
		}
		  
		String counValue = localValue.getCountry();
		boolean isValidCountry = false;
		if(isEmpty(counValue)) isValidCountry = true;
		String[] countries = Locale.getISOCountries();
		for(String isoCountryCode: countries) 
			 if(counValue.equalsIgnoreCase(isoCountryCode)) {
				 isValidCountry= true;
				 break;
			 }
		
		return isValidLanguage && isValidCountry;
		
	}


	public static boolean isValidLocale(String lan, String con){
			if(isEmpty(lan)) return false;
			 if(isEmpty(con)) return isValidLocale(new Locale(lan));
			 return isValidLocale(new Locale(lan,con));
	   }
	
	 public static boolean isNotEmpty(Locale locale){
			if(locale == null) return false;
			if(locale.getLanguage()==null) return false;
			return true;
	   } 

	 public static boolean isValidPositiveInt(String str){
		 	if(GenericValidator.isInt(str) && Integer.parseInt(str) >= 0) return true;
		 	return false;
	 }
	 
	 public static boolean isValidNegativeInt(String str){
		 	if(GenericValidator.isInt(str) && Integer.parseInt(str) < 0) return true;
		 	return false;
	 }
	 
	 public static boolean isInRange(Integer value,Integer min, Integer max){
		 	if(value!=null && min!=null && max!=null) return GenericValidator.isInRange(value,min,max);
		 	return false;
	 }


	 /**
	  * Protocol should be recognized
	  * @param url
	  * @return
	  */
	 @SuppressWarnings("unused")
	public static boolean isUrlValid(String url)	{
		 try {
			 URL urlObj = new URL(url);
		 } 
		 catch (MalformedURLException e) {
			 return false;
		 } 		 
		 
		 return true;
	 }
	 
	 /**
	  * Protocol need not be recognized
	  * @param url
	  * @return
	  */
	 @SuppressWarnings("unused")
	 public static boolean isUriValid(String url)	{
		 try {
			 int index = url.indexOf(":");
			 if (index>-1)	{
				 url = "http" + url.substring(index);
			 }
			 
			 
			URL urlObj = new URL(url);
		 } 
		 catch (MalformedURLException e) {
			 return false;
		 } 		 
		 
		 return true;
	 }
	 
	
	public static boolean isTrustedAppFamilyTypeValid(String trustedAppFamilyType) {
		
		return Constants.TRUSTEDAPP_FAMILY_TYPE_APP.equals(trustedAppFamilyType) |
			   Constants.TRUSTEDAPP_FAMILY_TYPE_CC_CONTAINER.equals(trustedAppFamilyType) |
			   Constants.TRUSTEDAPP_FAMILY_TYPE_CC_CONTAINER_APP.equals(trustedAppFamilyType) ;

	}
	
	public static boolean isValidIP(String ipaddress){
		InetAddressValidator ipaddressValidator = InetAddressValidator.getInstance();
		return ipaddressValidator.isValidInet4Address(ipaddress);
		
	}
	
	public static int parseUnSignedInt(String sValue, int defaultValue) {
		int result = 0;
		if(!ValidationUtil.isEmpty(sValue)) {
			try{
				result = Integer.parseInt(sValue);
			}catch(Exception ex){
				result = defaultValue;
			}
		}
		else {
			result = defaultValue;
		}
		
		if(result < 0){
			result = defaultValue;
		}
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isValidEmail(String email) {
		EmailValidator emailValidator = EmailValidator.getInstance();
		return emailValidator.isValid(email);
	}
}
