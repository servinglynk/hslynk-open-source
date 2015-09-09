package com.servinglynk.hmis.warehouse.service.core.test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.service.config.AppConfig;
import com.servinglynk.hmis.warehouse.service.core.HmisUserService;
import com.servinglynk.hmis.warehouse.service.core.HmisUserServiceImpl;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceImpl;


@ContextConfiguration(classes={AppConfig.class, DatabaseConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public abstract class BaseUnitTest {
	
	@Mock
	private ParentServiceImpl parentService;
	
	@Mock
	private HmisUserService hmisUserService;
	
	@Mock
	private ParentServiceFactory parentServiceFactory;

}
