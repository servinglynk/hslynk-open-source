package com.servinglynk.hmis.warehouse.enums;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class UuidUserType implements UserType {

	@SuppressWarnings( "unchecked" )
	public Class returnedClass() {
		return UUID.class;
	}

	public int[] sqlTypes() {
		return new int[] { Types.OTHER };
	}
	
	public boolean equals( Object x, Object y ) throws HibernateException {
		return (x == y) || (x != null && y != null && (x.equals(y)));
	}
	public Object assemble( Serializable cached, Object owner ) throws HibernateException {
		return deepCopy(cached);
	}

	public Serializable disassemble( Object value ) throws HibernateException {
		return (UUID) deepCopy(value);
	}

	// UUID is immutable, so we do not copy it actually
	public Object deepCopy( Object value ) throws HibernateException {
		return (UUID) value;
	}

	public int hashCode( Object x ) throws HibernateException {
		return x.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object replace( Object original, Object target, Object owner ) throws HibernateException {
		return original;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return rs.getObject(names[0]);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if ( value == null ) {
			st.setNull( index, Types.OTHER );
			return;
		} else {
			st.setObject(index, value);
		}
		
	}

}