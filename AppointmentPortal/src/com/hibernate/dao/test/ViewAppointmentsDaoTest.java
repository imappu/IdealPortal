package com.hibernate.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.AppointmentRegister;
import com.hibernate.dao.ViewAppointmentsDao;

public class ViewAppointmentsDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testViewAppointments() throws Exception {
		List<AppointmentRegister> appointmentRegister=new ArrayList<AppointmentRegister>();
		assertEquals(appointmentRegister,new ViewAppointmentsDao().viewAppointments(""));
	}
}
