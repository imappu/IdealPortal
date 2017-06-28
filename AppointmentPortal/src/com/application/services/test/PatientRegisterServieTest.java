package com.application.services.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.services.PatientRegisterServie;

public class PatientRegisterServieTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPatientRegisterServieIPatient() {
		assertEquals(0,new PatientRegisterServie().registerPatient());
		
	}
	
	

}
