package com.bean.builder;

import com.application.entity.Patient;
/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
public class PatientRegisterBuilder {

	/**
	 * Builds the PatientRegister instnace with contrcutor and returns it.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param contact
	 * @param email
	 * @param dob
	 * @param gender
	 * @param address
	 * @return
	 */
	public Patient buildPatientRegister(String firstName, String lastName, String password, String contact,
			String email, String dob, String gender, String address) {
		Patient patientRegister = new Patient(firstName, lastName, password, contact, email, dob, gender, address);
		return patientRegister;
	}
}
