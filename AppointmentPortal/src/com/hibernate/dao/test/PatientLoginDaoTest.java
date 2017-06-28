package com.hibernate.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.entity.PatientLogin;

public class PatientLoginDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPatientLoginAuthentication() {
		assertEquals(0,new AuthenticatorDao().
				getPatientLoginAuthentication((new PatientLogin("",""))));
	}

}
