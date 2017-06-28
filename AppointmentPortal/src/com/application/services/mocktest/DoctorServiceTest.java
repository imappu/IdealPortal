package com.application.services.mocktest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.application.common.InsertDao;
import com.application.entity.Doctor;
import com.application.services.DoctorService;

public class DoctorServiceTest {
	
	Doctor doctor = new Doctor();
	InsertDao doctorDao = mock(InsertDao.class);
	DoctorService doctorService = new DoctorService(doctor);
	
	@Test
	public void testProvideAppointment() {
		doctorService.setDoctorDao(doctorDao);
		when(doctorDao.registerDoctor(doctor)).thenReturn(10);
		assertEquals(10, doctorService.registerDoctor());
	}
}
