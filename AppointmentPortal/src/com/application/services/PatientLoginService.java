package com.application.services;

import org.apache.log4j.Logger;

import com.application.common.AuthenticatorDao;
import com.application.entity.PatientLogin;
import com.application.enums.FailureEnum;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class PatientLoginService {

	PatientLogin patientlogin = null;
	AuthenticatorDao patientLoginDao;
	/**
	 * PatientLoginService contructor.
	 * PatientLogin instance is constructor injected. 
	 * @param PatientLogin
	 */
	public PatientLoginService(PatientLogin patientlogin) {
		this.patientlogin = patientlogin;
	}
	/**
	 * This method matches the existing patient register details with logged user details and authenticates. 
	 * @return 1:If Patient is authenticated succesfully.
	 * 			0:If Patient is not authenticated.
	 */
	public int getAuthentication() {
		Logger logger = Logger.getLogger(PatientLoginService.class.getName());
		try {

			return patientLoginDao.getPatientLoginAuthentication(patientlogin);
		} catch (Exception e) {
			logger.info("problem occured in getAuthentication method of PatientLoginService class");
			logger.info(e.getStackTrace());
			return FailureEnum.failure.key();
		}
	}
	public void setPatientlogin(PatientLogin patientlogin) {
		this.patientlogin = patientlogin;
	}
	
	public void setPatientLoginDao(AuthenticatorDao patientLoginDao) {
		this.patientLoginDao = patientLoginDao;
	}
	public PatientLogin getPatientlogin() {
		return patientlogin;
	}
	
	
}
