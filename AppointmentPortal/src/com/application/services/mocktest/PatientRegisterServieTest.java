package com.application.services.mocktest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.common.InsertDao;
import com.application.entity.Patient;
import com.application.services.PatientRegisterServie;

public class PatientRegisterServieTest {

	Patient patient = new Patient();
	AuthenticatorDao patientDao = mock(AuthenticatorDao.class);
	InsertDao insertDao=mock(InsertDao.class);
	
	PatientRegisterServie patientRegisterServie = new PatientRegisterServie(patient);

	@Test
	public void testregisterPatient() throws SQLIntegrityConstraintViolationException  {
		patientRegisterServie.setInsertDao(insertDao);
		when(insertDao.registerPatient(patient)).thenReturn(10);
		assertEquals(10, patientRegisterServie.registerPatient());
	}
	
}
