package com.application.services;

import org.apache.log4j.Logger;

import com.application.common.InsertDao;
import com.application.entity.Doctor;
import com.application.enums.FailureEnum;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class DoctorService {

	Doctor doctor;
	InsertDao doctorDao;
	/**
	 * DoctorService contructor.
	 * Doctor instance is constructor injected. 
	 * @param Doctor
	 */
	public DoctorService(Doctor doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * This method persist the doctor details in doctorentity table using doctor dao classes.
	 * @return 1: If doctor details are saved successfully. 
	 *			0:If doctor details are not saved. 
	 */	
	public int registerDoctor() {
		Logger logger = Logger.getLogger(DoctorService.class.getName());
		try {
			return doctorDao.registerDoctor(doctor);
		}

		catch (Exception e) {
			logger.info("problem in registerDoctor method of DoctorService class");
			logger.info(e.getStackTrace());
			return FailureEnum.failure.key();
		}
	}

	public void setDoctorDao(InsertDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
