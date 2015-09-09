package com.servinglynk.hmis.warehouse.service.core.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.servinglynk.hmis.warehouse.service.core.EnrollmentServiceImpl;


public class EnrollmentServiceTest extends BaseUnitTest {
	
	@InjectMocks
	private EnrollmentServiceImpl service = new EnrollmentServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Ignore
	public void testEnrollmentService() {
		service.addEnrollment();
	}
	

}
