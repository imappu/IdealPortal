package com.hibernate.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.entity.Admin;

public class AdminDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAdminauthentication() {
		assertEquals(0,new AuthenticatorDao().getAdminauthentication(new Admin("","")));
	}

}
