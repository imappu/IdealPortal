package com.application.services.mocktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.application.entity.AppointmentRegister;
import com.application.services.AppointmentService;
import com.hibernate.dao.AppointementRegisterDao;

public class AppointmentServiceTest {

	AppointmentRegister appointmentRegister = new AppointmentRegister();
	AppointementRegisterDao appointementRegisterDao = mock(AppointementRegisterDao.class);
	AppointmentService appointmentService = new AppointmentService(appointmentRegister);

	@Test
	public void testProvideAppointment() throws Exception {
		appointmentService.setAppointmentRegister(appointmentRegister);
		when(appointementRegisterDao.getBookedAppointments("")).thenReturn(0);
		assertEquals(0, appointmentService.provideAppointment(""));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testProvideAppointmentException() throws Exception {
		boolean thrown = false;
		appointmentService.setAppointmentRegister(appointmentRegister);
		when(appointementRegisterDao.getBookedAppointments("")).thenThrow(Exception.class);
		try {
			appointementRegisterDao.getBookedAppointments("");
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

}
