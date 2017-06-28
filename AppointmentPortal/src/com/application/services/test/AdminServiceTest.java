package com.application.services.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.Admin;
import com.application.services.AdminService;

public class AdminServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void authenticateAdminTest() {
		assertEquals(0,new AdminService(new Admin("","")).authenticateAdmin());
	}

}
