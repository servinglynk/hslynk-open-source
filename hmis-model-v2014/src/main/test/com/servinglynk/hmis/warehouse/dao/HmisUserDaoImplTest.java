package com.servinglynk.hmis.warehouse.dao;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.dao.HmisUserDaoImpl;
import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
public class HmisUserDaoImplTest {
	@Autowired
	HmisUserDaoImpl dao;
	
	@Test
	@Transactional
	public void test()
	{
		HmisUser user = new HmisUser();
		//user.setId(UUID.randomUUID());
		user.setFirstName("TEst");
		dao.addHmisUser(user);
		System.out.println(dao.getHmisUsers().size());
	}

	
	@Test
	@Transactional
	@Ignore
	public void size()
	{
		System.out.println(dao.getHmisUsers().size());
	}
}
