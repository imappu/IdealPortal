package com.application.services;

import com.application.common.AuthenticatorDao;

public class PatientConfirmerService {
	AuthenticatorDao authenticatorDao = new AuthenticatorDao();

	public int getPatieentConfirmation(String username, String date, String time) {
		try {
			return authenticatorDao.getPatientConfirmation(username, date, time);
		}

		catch (Exception e) {
			return 0;
		}
	}
}
