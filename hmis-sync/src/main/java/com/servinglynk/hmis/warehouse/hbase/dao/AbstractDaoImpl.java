package com.servinglynk.hmis.warehouse.hbase.dao;

import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.servinglynk.hmis.warehouse.hbase.model.HbaseEntity;

public abstract class AbstractDaoImpl<T extends Object> {

	public void save(HbaseEntity entity) throws TIOError, TException {
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
		performSave(client,entity);
		transport.close();
	}
	
	public List<T> get(HbaseEntity entity) throws TIOError, TException {
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

	protected abstract void performSave(THBaseService.Iface client, HbaseEntity entity);
	protected abstract List<T> performGet(THBaseService.Iface client, HbaseEntity entity);
}
