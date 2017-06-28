package com.test.beanbuilder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.PatientLogin;
import com.bean.builder.PatientLoginBuilder;

public class PatientLoginBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildPatientLogin() {
		assertEquals(true,new PatientLoginBuilder().buildPatientLogin("","") instanceof PatientLogin);
	}

}
