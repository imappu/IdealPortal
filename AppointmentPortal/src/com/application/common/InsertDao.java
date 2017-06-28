package com.application.common;

import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Doctor;
import com.application.enums.FailureEnum;
import com.application.enums.SuccessEnum;
import com.application.interfaces.IPatient;
import com.hibernateutil.HibernateUtil;

public class InsertDao {
	Logger logger = Logger.getLogger(InsertDao.class.getName());
	/**
	 * This method verifies the registered patient details and if patient is not registered then  saves the Patient details in patiententity table. 
	 * @param PatientRegister
	 * @return:1:If Patient details are successfully saved.
	 * 			0:If Patient details are not succesfully saved.
	 * @throws SQLIntegrityConstraintViolationException: If Patient is already registered or email id already exist .
	 */
	public int registerPatient(IPatient patient) throws SQLIntegrityConstraintViolationException {

		try {
			Session session = HibernateUtil.getSesion();
			Transaction transaction = session.beginTransaction();
			int result = new AuthenticatorDao().getUsernameIdentity(patient.getContact());

			if (result == 1) {
				session.save(patient);
				transaction.commit();
				session.close();
				return SuccessEnum.success.key();
			}

			else {
				return FailureEnum.failure.key();
			}
		}

		catch (Exception exception) {
			logger.info("Problem in registerPatient method of PatientDao class ");
			logger.info(exception.getStackTrace());
			return FailureEnum.failure.key();
		}
	}
	
/**
 * Doctor registration method	
 * @param doctor
 * @return 1 if successfull else 0
 */
public int registerDoctor(Doctor doctor) {
		
		try {
			Session session = HibernateUtil.getSesion();
			Transaction t = session.beginTransaction();
			int doctorAuth = new AuthenticatorDao().getDoctorIdentity(doctor.getDoctorid());
			if (doctorAuth == 1) {
				session.save(doctor);
				t.commit();
				session.close();
				return SuccessEnum.success.key();

			}

			else {
				return FailureEnum.failure.key();
			}
		} catch (Exception exception) {
			logger.info("Problem Occured in registerDoctor method of DoctorDao class");
			logger.info(exception.getStackTrace());
			return FailureEnum.failure.key();
		}
	}

}
