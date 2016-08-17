package com.servinglynk.hmis.warehouse.client.baseclients;

import com.servinglynk.hmis.warehouse.client.model.BaseClients;
import com.servinglynk.hmis.warehouse.client.model.Session;

public interface BaseClientService {

	BaseClients getClients(Session session) throws Exception;
}
