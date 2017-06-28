package com.hibernate.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.common.InsertDao;
import com.application.entity.Doctor;

public class DoctorDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegisterDoctor() {
		assertEquals(1,new InsertDao().registerDoctor(new Doctor()));
}

	@Test
	public void testGetDoctorIdentity() {
		assertEquals(1,new AuthenticatorDao().getDoctorIdentity(0));
	}

}
