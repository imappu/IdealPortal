package com.test.beanbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.Admin;
import com.bean.builder.AdminBuilder;

public class AdminBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildAdmin() {
		assertEquals(true, new AdminBuilder().buildAdmin("","") instanceof Admin);
	}


}
