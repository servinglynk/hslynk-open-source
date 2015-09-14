package com.servinglynk.hmis.warehouse.sync.dao;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.hadoop.hbase.thrift2.generated.TColumnValue;
import org.apache.hadoop.hbase.thrift2.generated.TGet;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.hadoop.hbase.thrift2.generated.TPut;
import org.apache.hadoop.hbase.thrift2.generated.TResult;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.sync.hbase.model.HbaseEntity;
import com.servinglynk.hmis.warehouse.sync.hbase.model.HmisUser;
import com.servinglynk.hmis.warehouse.sync.hbase.model.HmisUser.Personal;
import com.servinglynk.hmis.warehouse.sync.hbase.model.HmisUser.Professional;

@Component
public class SyncUserDao extends AbstractDaoImpl<HmisUser> {

	public void syncHmisUser(HmisUser user) {
		try {
			save(user);
		} catch (TIOError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void performSave(Iface client, HbaseEntity entity) {
		HmisUser user = (HmisUser) entity;
		ByteBuffer table = ByteBuffer.wrap(user.getTableName().getBytes());

		TPut put = new TPut();
		put.setRow(user.getId().getBytes());
		List<TColumnValue> columnValues = new ArrayList<TColumnValue>();
		for (String columnFamily : user.getColumnFamilies()) {
			List<String> columns = user.getColumns(columnFamily);
			for (String column : columns) {
				TColumnValue columnValue = new TColumnValue();
				columnValue.setFamily(columnFamily.getBytes());
				columnValue.setQualifier(column.getBytes());
				Object value = null;
				Object columnFamilyObject = null;
				try {
					try {
						columnFamilyObject = PropertyUtils.getProperty(user,
								columnFamily);
						if (columnFamilyObject != null) {
							value = PropertyUtils.getProperty(
									columnFamilyObject, column);
						}
					} catch (IllegalAccessException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value != null) {
					columnValue.setValue(String.valueOf(value).getBytes());
					columnValue.setTimestamp(System.currentTimeMillis());
					columnValues.add(columnValue);
				}

			}
		}
		put.setColumnValues(columnValues);
		try {
			client.put(table, put);
		} catch (TIOError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected List<HmisUser> performGet(Iface client, HbaseEntity entity) {
		HmisUser user = (HmisUser) entity;
		ByteBuffer table = ByteBuffer.wrap(user.getTableName().getBytes());
		List<HmisUser> users = new ArrayList<>();
		TGet get = new TGet();
		get.setRow(user.getId().getBytes());
		get.setMaxVersions(5);
		TResult result = null;
		try {
			result = client.get(table, get);
		} catch (TIOError | TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result != null) {
			HmisUser hmisUser = new HmisUser();
			hmisUser.setId(user.getId());
			Personal personal = user.new Personal();
			Professional professional = user.new Professional();
			hmisUser.setPersonal(personal);
			hmisUser.setProfessional(professional);
			for (TColumnValue resultColumnValue : result.getColumnValues()) {
				try {
					String columnFamily = new String(
							resultColumnValue.getFamily());
					String qualifier = new String(
							resultColumnValue.getQualifier());
					Object columnFamilyObject = PropertyUtils.getProperty(
							hmisUser, columnFamily);
					List<String> columns = user.getColumns(columnFamily);
					for (String column : columns) {
						if (column.equalsIgnoreCase(qualifier)) {
							qualifier = column;
						}
					}
					if ("dob".equals(qualifier)) {
						if (resultColumnValue.getValue() != null) {
//							PropertyUtils.setProperty(columnFamilyObject,
//									qualifier, new Date(new String(
//											resultColumnValue.getValue())));
						}
					} else {
						if (resultColumnValue.getValue() != null) {
							PropertyUtils.setProperty(columnFamilyObject,
									qualifier,
									new String(resultColumnValue.getValue()));
						}
					}
					PropertyUtils.setProperty(hmisUser, columnFamily,
							columnFamilyObject);
				} catch (IllegalAccessException | InvocationTargetException
						| NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				users.add(hmisUser);
			}
		}

		return users;
	}

}
