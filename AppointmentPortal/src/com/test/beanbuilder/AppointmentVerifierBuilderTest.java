package com.test.beanbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.AppointmentVerifier;
import com.bean.builder.AppointmentVerifierBuilder;

public class AppointmentVerifierBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildAppointmentVerifier() {
		assertEquals(true,new AppointmentVerifierBuilder().buildAppointmentVerifier("","","","") instanceof AppointmentVerifier);
	}

}
