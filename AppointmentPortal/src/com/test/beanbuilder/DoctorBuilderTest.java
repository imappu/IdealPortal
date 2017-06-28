package com.test.beanbuilder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.Doctor;
import com.bean.builder.DoctorBuilder;

public class DoctorBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildDoctor() {
		assertEquals(true,new DoctorBuilder().buildDoctor("","","") instanceof Doctor);
	}

}
