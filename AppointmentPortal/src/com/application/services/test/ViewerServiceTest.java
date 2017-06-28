package com.application.services.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.application.entity.AppointmentRegister;
import com.application.services.ViewerService;

public class ViewerServiceTest {
List<AppointmentRegister> list=new ArrayList<AppointmentRegister>();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testViewAppointments() throws Exception {
		assertEquals( list,new ViewerService().viewAppointments(""));
	}

}
