package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class Clients extends PaginatedModel {
	
	private List<Client> clients = new ArrayList<Client>();

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	

	public void addClient(Client client){
		this.clients.add(client);
	}

}