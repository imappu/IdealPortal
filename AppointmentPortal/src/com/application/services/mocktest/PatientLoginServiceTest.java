package com.application.services.mocktest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.entity.PatientLogin;
import com.application.services.PatientLoginService;

public class PatientLoginServiceTest {

	PatientLogin patientLogin = new PatientLogin("", "");
	AuthenticatorDao patientLoginDao = mock(AuthenticatorDao.class);
	PatientLoginService patientLoginService = new PatientLoginService(patientLogin);

	@Test
	public void testGetAuthentication() {
		patientLoginService.setPatientLoginDao(patientLoginDao);
		when(patientLoginDao.getPatientLoginAuthentication(patientLogin)).thenReturn(10);
		assertEquals(10, patientLoginService.getAuthentication());
	}

}
