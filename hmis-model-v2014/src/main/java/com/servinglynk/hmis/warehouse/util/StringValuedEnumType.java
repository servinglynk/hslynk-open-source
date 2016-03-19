package com.servinglynk.hmis.warehouse.util;

/**
 * @author Sandeep Dolia
 *
 */
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;

/**
 * For internal hibernate use.
 * 
 * @author unknown
 *
 * @param <T>
 */

// Please notice the calls to getNameFromValue *************************
@SuppressWarnings({ "unchecked", "rawtypes" })
public class StringValuedEnumType<T extends Enum> implements
		org.hibernate.usertype.UserType, ParameterizedType {

	/**
	 * Enum class for this particular user type.
	 */
	private Class<T> enumClass;
	/** For postgres. */
	private boolean pgEnum;
	/** ClassLoader to use. */
	private static ClassLoader classLoader;

	/**
	 * Sets the classloader to be used when loading classes reflectively.
	 * 
	 * @param classLoader
	 *            to use
	 */
	public static void setClassLoader(ClassLoader classLoader) {
		StringValuedEnumType.classLoader = classLoader;
	}

	/**
	 * Value to use if null.
	 */
	private String defaultValue;

	/** Creates a new instance of ActiveStateEnumType. */
	public StringValuedEnumType() {
		StringValuedEnumType.classLoader = Thread.currentThread()
				.getContextClassLoader();
		// do nothing
	}

	/**
	 * Sets param values.
	 * 
	 * @param parameters
	 *            params
	 */
	public void setParameterValues(Properties parameters) {
		String enumClassName = parameters.getProperty("enum");
		String enumPostgres = parameters.getProperty("forPgSQL");
		try {
			this.enumClass = (Class<T>) Class.forName(enumClassName, true,
					StringValuedEnumType.classLoader).asSubclass(Enum.class);
			this.pgEnum = "true".equalsIgnoreCase(enumPostgres);
		} catch (ClassNotFoundException cnfe) {
			throw new HibernateException("Enum class not found", cnfe);
		}

		setDefaultValue(parameters.getProperty("defaultValue"));
	}

	/**
	 * Gets the default value.
	 * 
	 * @return default value
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * Sets the default value.
	 * 
	 * @param defaultValue
	 *            default value.
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * The class returned by <tt>nullSafeGet()</tt>.
	 * 
	 * @return Class
	 */
	public Class returnedClass() {
		return this.enumClass;
	}

	/**
	 * Internal.
	 * 
	 * @return sqlTypes int
	 */
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	/**
	 * Internal.
	 * 
	 * @return mutable
	 */
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
			SessionImplementor arg3) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieve an instance of the mapped class from a JDBC resultset.
	 * Implementors should handle possibility of null values.
	 *
	 * @param rs
	 *            a JDBC result set
	 * @param names
	 *            the column names
	 * @param owner
	 *            the containing entity
	 * @return Object
	 * @throws HibernateException
	 *             on error
	 * @throws SQLException
	 *             on error
	 */
	

}
