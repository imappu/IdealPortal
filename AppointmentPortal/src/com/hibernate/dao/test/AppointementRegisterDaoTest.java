package com.hibernate.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.AppointmentRegister;
import com.hibernate.dao.AppointementRegisterDao;

public class AppointementRegisterDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/*@Test
	public void testgetDoctorRowcount() {
		List<Doctor> doctorList=new ArrayList<Doctor>();
		assertEquals(doctorList,new AppointementRegisterDao(new AppointmentRegister()).getDoctorRowcount());
	}

	@Test
	public void testsaveAppoitmentDetails() {
		assertEquals(1,new AppointementRegisterDao(new AppointmentRegister()).saveAppoitmentDetails());
	}*/
	
	@Test
	public void testgetBookedAppointments() throws Exception {
		assertEquals(0,new AppointementRegisterDao(new AppointmentRegister()).getBookedAppointments(""));
	}
	
}
