package com.bean.builder;

import com.application.entity.PatientLogin;
/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class PatientLoginBuilder {

	/**
	 * Builds and returns the PatientLogin instance and returns it.
	 * @param userName
	 * @param password
	 * @return
	 */
	public PatientLogin buildPatientLogin(String userName,String password)
	{
		
		PatientLogin patientLogin=new PatientLogin(userName, password);
		return patientLogin;
	}
}
