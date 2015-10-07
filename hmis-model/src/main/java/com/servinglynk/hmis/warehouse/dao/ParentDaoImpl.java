package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.live.Sync;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {

	public void saveHBase(Object entity) throws TIOError, TException {
		String host = "54.149.8.196";
		int port = 9095;
		int timeout = 10000;
		boolean framed = false;

		TTransport transport = new TSocket(host, port, timeout);
		if (framed) {
			transport = new TFramedTransport(transport);
		}
		TProtocol protocol = new TBinaryProtocol(transport);
		// This is our thrift client.
		THBaseService.Iface client = new THBaseService.Client(protocol);

		// open the transport
		transport.open();
		performSave(client,entity);
		transport.close();
	}
	
	public List<T> recordsToSync(Class t, SyncDomain domain) {
		DetachedCriteria criteria = DetachedCriteria.forClass(t);
		// criteria.add(Restrictions.("status",status)); Need to pass the date here .
		criteria.add(Restrictions.gt("dateCreated", domain.getDateCreated()));
		if(criteria.getExecutableCriteria(getCurrentSession()).list() != null) {
			return criteria.getExecutableCriteria(getCurrentSession()).list();
		}
		return null;

	}
	
	public List<T> getFromHBASE(Object entity) throws TIOError, TException {
		String host = "54.149.8.196";
		int port = 9090;
		int timeout = 10000;
		boolean framed = false;

		TTransport transport = new TSocket(host, port, timeout);
		if (framed) {
			transport = new TFramedTransport(transport);
		}
		TProtocol protocol = new TBinaryProtocol(transport);
		// This is our thrift client.
		THBaseService.Iface client = new THBaseService.Client(protocol);

		// open the transport
		transport.open();
		List<T> t =  performGet(client,entity);
		transport.close();
		return t;
	}

	protected abstract void performSave(THBaseService.Iface client, Object entity);
	protected abstract List<T> performGet(THBaseService.Iface client, Object entity);
	
	protected String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		
		int i=0;
		for(Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if(genericType != null ){
				String fieldName = field.getName();
				if(fieldName !=null && genericType.getTypeName().contains("Set")){
						fieldsArray[++i]= field.getName();	
				}
				if("serialVersionUID".equals(fieldName) || "SAVED_HASHES".equals(fieldName) || "hashCode".equals(fieldName)) {
					fieldsArray[++i]= field.getName();	
				}
				
			}
		}
		return fieldsArray;
	}
	protected String[] getNonCollectionFieldsForObject(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		
		int i=0;
		for(Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if(genericType != null ){
				String fieldName = field.getName();
				if(fieldName !=null && !genericType.getTypeName().contains("Set")){
						fieldsArray[++i]= field.getName();	
				}
				if(!"serialVersionUID".equals(fieldName) && !"SAVED_HASHES".equals(fieldName) && !"hashCode".equals(fieldName)) {
					fieldsArray[++i]= field.getName();	
				}
				
			}
		}
		return fieldsArray;
	}
	protected THBaseService.Iface geHBaseClient() {
		String host = "52.27.63.94";
		int port = 9095;
		int timeout = 10000;
		boolean framed = false;

		TTransport transport = new TSocket(host, port, timeout);
		if (framed) {
			transport = new TFramedTransport(transport);
		}
		TProtocol protocol = new TBinaryProtocol(transport);
		// This is our thrift client.
		THBaseService.Iface client = new THBaseService.Client(protocol);

		// open the transport
		try {
			transport.open();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
}
