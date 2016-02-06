package com.servinglynk.hmis.warehouse.service;

import java.util.Properties;

public interface PropertyReaderService {
	Properties readProperties(String serviceName);
	Properties getApplicationProperties();
	Properties loadProperties(String serviceName);
}
