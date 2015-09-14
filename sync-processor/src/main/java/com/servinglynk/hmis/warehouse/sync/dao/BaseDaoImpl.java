package com.servinglynk.hmis.warehouse.sync.dao;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class BaseDaoImpl {
	protected THBaseService.Iface geHBaseClient() {
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
		try {
			transport.open();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

}
