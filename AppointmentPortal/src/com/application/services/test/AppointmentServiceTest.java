package com.application.services.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.AppointmentRegister;
import com.hibernate.dao.AppointementRegisterDao;

public class AppointmentServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProvideAppointment() throws Exception {
		assertEquals(0,new AppointementRegisterDao(new AppointmentRegister()).getBookedAppointments(""));
	}
	
}
