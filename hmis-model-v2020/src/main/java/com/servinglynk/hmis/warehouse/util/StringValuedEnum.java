package com.servinglynk.hmis.warehouse.util;

/**
 * Utility class designed to allow dynamic fiddling and manipulation of Enum
 * instances which hold a string value.
 * 
 * @author Sandeep Dolia
 */
public interface StringValuedEnum {

	/**
	 * Current string value stored in the enum.
	 * 
	 * @return string value.
	 */
	String getValue();

}