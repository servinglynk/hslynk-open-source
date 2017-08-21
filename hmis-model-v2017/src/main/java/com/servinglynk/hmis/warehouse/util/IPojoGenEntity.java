package com.servinglynk.hmis.warehouse.util;

import java.io.Serializable;

/**
 * All generated model classes implement this interface.
 *
 * @author Sandeep Dolia
 */
public interface IPojoGenEntity {

	/**
	 * Return the type of this class. Useful for when dealing with proxies.
	 * 
	 * @return Defining class.
	 */
	Class<?> getClassType();

	/**
	 * Return the id.
	 *
	 * @return the id.
	 */
	Serializable getId();

}
