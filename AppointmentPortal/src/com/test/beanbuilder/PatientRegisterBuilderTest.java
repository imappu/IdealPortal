package com.test.beanbuilder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.Patient;
import com.bean.builder.PatientRegisterBuilder;

public class PatientRegisterBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildPatientRegister() {
		assertEquals(true,new PatientRegisterBuilder().buildPatientRegister("","", "","","","","","") instanceof Patient);
	}

}
