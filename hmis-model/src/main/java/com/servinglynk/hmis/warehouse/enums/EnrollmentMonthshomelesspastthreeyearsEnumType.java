package com.servinglynk.hmis.warehouse.enums;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import com.servinglynk.hmis.warehouse.util.GenericEnumType;

public class EnrollmentMonthshomelesspastthreeyearsEnumType   extends GenericEnumType<String, EnrollmentHousingstatusEnum> {
	public EnrollmentMonthshomelesspastthreeyearsEnumType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		super(EnrollmentHousingstatusEnum.class, EnrollmentHousingstatusEnum.values(), "getValue", Types.OTHER);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		return nullSafeGet(rs, names, owner);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		nullSafeSet(st, value, index);
	}

}
