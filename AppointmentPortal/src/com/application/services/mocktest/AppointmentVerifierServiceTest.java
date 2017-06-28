package com.application.services.mocktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.application.entity.AppointmentVerifier;
import com.application.services.AppointmentVerifierService;
import com.hibernate.dao.AppointementVerifierDao;

public class AppointmentVerifierServiceTest {

	AppointmentVerifier appointmentVerifier = new AppointmentVerifier();
	AppointementVerifierDao appointementVerifierDao = mock(AppointementVerifierDao.class);
	AppointmentVerifierService appointmentVerifierService = new AppointmentVerifierService(appointmentVerifier);
	

	

}
