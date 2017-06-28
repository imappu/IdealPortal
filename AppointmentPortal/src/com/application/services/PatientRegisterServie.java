package com.application.services;
import java.util.List;

import org.apache.log4j.Logger;

import com.application.common.AuthenticatorDao;
import com.application.common.InsertDao;
import com.application.entity.Patient;
import com.application.interfaces.IPatient;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class PatientRegisterServie {

	IPatient patient = null;
	AuthenticatorDao patientDao = new AuthenticatorDao();
	InsertDao insertDao;
	Logger logger = Logger.getLogger(PatientRegisterServie.class.getName());
	/**
	 * PatientRegisterServie contructor.
	 * PatientRegister instance is constructor injected. 
	 * @param PatientRegister
	 */
	public PatientRegisterServie(IPatient patient) {
		this.patient = patient;
	}

	public PatientRegisterServie() {

	}

	/**
	 * This method persist the Patient details in patiententity table using patient dao classes.
	 * @return 1: If patient details are saved successfully. 
	 *			0:If patient details are not saved. 
	 */	
	public int registerPatient()

	{
		
		try {
			
			return insertDao.registerPatient(patient);

		} catch (Exception e) {
			logger.info("Problem in registerPatient method of PatientRegisterServie");
			logger.info(e.getStackTrace());

			return 0;
		}

	}
/**
 * Method proviedes patient details to view controller to form a patient and doctor viewer object 
 * @param username
 * @return:List<Patient> which is fetched from patiententity table.
 */
	public List<Patient> getPatientDetailsForView(String username) {
		List<Patient> patienList = null;
		try {
			patienList = patientDao.getPatietDetails(username);
			return patienList;
		}

		catch (Exception e) {
			logger.info("Problem in getPatientDetailsForView method of PatientRegisterServie class");
			return patienList;
		}

	}

	public AuthenticatorDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(AuthenticatorDao patientDao) {
		this.patientDao = patientDao;
	}

	public void setInsertDao(InsertDao insertDao) {
		this.insertDao = insertDao;
	}

}
