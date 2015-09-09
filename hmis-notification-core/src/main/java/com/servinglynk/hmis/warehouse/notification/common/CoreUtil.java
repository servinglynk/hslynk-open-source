package com.servinglynk.hmis.warehouse.notification.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;

public final class CoreUtil {
	private CoreUtil(){}
	
	public static String capitalizeString(String str){
		return StringUtils.capitalize(str);
	}
	
	
	private static SecureRandom random = new SecureRandom();

	  public static String createUniqueId() {
	    return new BigInteger(130, random).toString(32);
	  }
	
	public static String chompString(String str, String stringToRemove){
		return StringUtils.chomp(str, stringToRemove);
	}
	
	public static boolean notNull(Object obj){
		return obj!=null;
	}
	
	public static String emptyString(){
		return "";
	}
	
	public static boolean  isEmpty(String str){
		if(StringUtils.isWhitespace(str)) return true;
		return StringUtils.isEmpty(str);
	}
	
	public static String capitalizeWords(String str){
		return WordUtils.capitalizeFully(str);
	}

	public static String abbreviate(String str, int width){
		return StringUtils.abbreviate(str, width);
	}
	
	public static String clean(String str){
		return StringUtils.trimToEmpty(str);
	}
	
	public static boolean contains(String str, String searchString, boolean checkCase){
		if(checkCase) return StringUtils.contains(str, searchString);
		return StringUtils.containsIgnoreCase(str, searchString);
	}
	


	private static String generateUniqueID() {
		return UUID.randomUUID().toString();
	}
	
	
	
	public static String createUniqueID(boolean alphaNumeric) {
		String uniqueID =  generateUniqueID();
		if(alphaNumeric)	return uniqueID.replaceAll("-","");
		return uniqueID;
	}
	
	public static Integer toIntegerWithDefault(String str, Integer defaultValue){
		return NumberUtils.toInt(str,defaultValue);
	}
	
	public static Integer toIntegerWithDefault(Integer integer, Integer defaultValue){
		if(integer==null) 	return NumberUtils.toInt(null,defaultValue);
		return toIntegerWithDefault(integer.toString(),defaultValue);
	}
	
	public static boolean isEmpty(Collection<?> collection){
		return collection.isEmpty();
	}
	
	public static <T> T toObject(InputStream is,Class<T> valueType) throws Exception{
		String json = isToString(is);
		return convertJSONtoJava(json, valueType);
}


	public static <T> T convertJSONtoJava(String json, Class<T> valueType) throws Exception {
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		return objectMapper.readValue(json, valueType);
	}
	
	public static String isToString(InputStream inputStream){
        StringBuilder stringBuilder = new StringBuilder();   
        BufferedReader bufferedReader = null;   
        try {   
            // read the payload into the StringBuilder   
            
            if (inputStream != null) {   
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));   
                char[] charBuffer = new char[128];   
                int bytesRead = -1;   
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {   
                    stringBuilder.append(charBuffer, 0, bytesRead);   
                }   
            } else {   
                stringBuilder.append("");   
            }   
        } catch (IOException ex) {   
            //ignore   
        } finally {   
            if (bufferedReader != null) {   
                try {   
                    bufferedReader.close();   
                } catch (IOException iox) {   
                    // ignore   
                }   
            }   
        }   
        return stringBuilder.toString();
	}

	
	
	
}
