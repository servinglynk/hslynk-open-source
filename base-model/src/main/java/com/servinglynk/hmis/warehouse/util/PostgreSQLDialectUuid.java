package com.servinglynk.hmis.warehouse.util;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;

public class PostgreSQLDialectUuid extends PostgreSQLDialect {
	
	public PostgreSQLDialectUuid() {
		super();
		registerColumnType(Types.OTHER, "uuid");
	}

}
