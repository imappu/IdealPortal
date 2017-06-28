package com.application.services;

import java.util.List;

import com.application.common.AuthenticatorDao;
import com.application.entity.Doctor;

public class DoctorVerifierService {
AuthenticatorDao authenticatorDao;
	
	public List<Doctor> getDoctorListForAppointmentBooking(String department)
	{
		List<Doctor> doctorList = null;
		try
		{	
			doctorList= authenticatorDao.getDoctorListForAppointmentBooking(department);
			return doctorList;
		}
		catch (Exception e) {
			return doctorList;
		}
		
	}

	public Doctor getSelectedDoctorDetails(String doctorName)
	{
	try {	
		System.out.println("we are in service with doctor name"+ doctorName );
		return new AuthenticatorDao().getselectedDoctorForAppointmentBooking(doctorName);
	}
	catch (Exception e) {e.printStackTrace();
	return null;
	}
	
	}
	
	public void setAuthenticatorDao(AuthenticatorDao authenticatorDao) {
		this.authenticatorDao = authenticatorDao;
	}
	
}
