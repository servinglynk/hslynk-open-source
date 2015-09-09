package com.servinglynk.hmis.warehouse.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.hbase.config.HbaseConfig;
import com.servinglynk.hmis.warehouse.hbase.model.HmisUser;
import com.servinglynk.hmis.warehouse.hbase.model.HmisUser.Personal;
import com.servinglynk.hmis.warehouse.hbase.model.HmisUser.Professional;
import com.servinglynk.hmis.warehouse.hbase.service.SyncUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HbaseConfig.class,loader = AnnotationConfigContextLoader.class)
public class SyncUserServiceImplTest  {
	
	@Autowired
	private SyncUserService syncService;

	@Test
	public void test()
	{
		List<HmisUser> users = new ArrayList<HmisUser>();
		HmisUser user = new HmisUser();
		user.setId("ro21");
		Personal personal = user.new Personal();
		personal.setFirstName("Jamie");
		personal.setLastName("Anderson");
		personal.setMiddleName("ksl");
		personal.setGender("1");
		personal.setDob(new Date());
		personal.setSsn("1234567890");
		
		user.setPersonal(personal);
		Professional professional = user.new Professional();
		user.setProfessional(professional);
		users.add(user);
		syncService.syncHmisUser(users);
	}
	@Test
	public void testGet()
	{
		//List<HmisUser> users = new ArrayList<HmisUser>();
		HmisUser user = new HmisUser();
		user.setId("ro21");
		List<HmisUser> users = syncService.getHmisUser("ro21");
	}
}
