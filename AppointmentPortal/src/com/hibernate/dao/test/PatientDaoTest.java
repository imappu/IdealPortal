package com.hibernate.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.common.InsertDao;
import com.application.entity.Patient;

public class PatientDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegisterPatient() throws SQLIntegrityConstraintViolationException {
		assertEquals(1,new InsertDao().registerPatient(new Patient()));
	}

	@Test
	public void testgetUsernameIdentity() {
		assertEquals(1,new AuthenticatorDao().getUsernameIdentity(""));
	}
	
	@Test
	public void testgetPatietDetails() {
		List<Patient> userList=new ArrayList<>();
		assertEquals(userList,new AuthenticatorDao().getPatietDetails(""));
	}
	
	


}
