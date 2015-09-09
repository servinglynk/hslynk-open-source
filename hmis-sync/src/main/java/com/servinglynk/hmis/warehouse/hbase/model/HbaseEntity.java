package com.servinglynk.hmis.warehouse.hbase.model;

import java.io.Serializable;
import java.util.List;

public abstract class HbaseEntity implements Serializable{

	public abstract String getTableName();
	public abstract List<String> getColumnFamilies();
	public abstract List<String> getColumns(String columnFamily);
}
