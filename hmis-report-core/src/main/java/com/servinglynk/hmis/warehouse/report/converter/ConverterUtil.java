package com.servinglynk.hmis.warehouse.report.converter;

import java.lang.reflect.Field;

public class ConverterUtil {
	
	public static <T extends Object, Y extends Object> void copyFields(T from, Y too) {

	    Class<? extends Object> fromClass = from.getClass();
	    Field[] fromFields = fromClass.getDeclaredFields();

	    Class<? extends Object> tooClass = too.getClass();
	    Field[] tooFields = tooClass.getDeclaredFields();

	    if (fromFields != null && tooFields != null) {
	        for (Field tooF : tooFields) {
	            
	            try {
	                // Check if that fields exists in the other method
	                Field fromF = fromClass.getDeclaredField(tooF.getName());
	                if (fromF.getType().equals(tooF.getType())) {
	                	fromF.setAccessible(true);
	                    tooF.setAccessible(true);
	                    tooF.set(too, fromF.get(from));
	                }
	            } catch (SecurityException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (NoSuchFieldException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IllegalArgumentException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }

	        }
	    }
	}
}
