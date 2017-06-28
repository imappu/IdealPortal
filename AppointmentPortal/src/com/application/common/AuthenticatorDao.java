package com.application.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Admin;
import com.application.entity.AppointmentRegister;
import com.application.entity.Doctor;
import com.application.entity.Patient;
import com.application.entity.PatientLogin;
import com.application.enums.FailureEnum;
import com.application.enums.SuccessEnum;
import com.hibernateutil.HibernateUtil;

public class AuthenticatorDao {
	Logger logger = Logger.getLogger(AuthenticatorDao.class.getName());
/**
 * To get the doctor details like employee id and doctor name we need this method
 * @param doctorName
 * @return
 */
	
	
	/**
	 * get Doctor For Appointment Booking
	 * 
	 * @param doctorname
	 * @return: doctor object
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Doctor getselectedDoctorForAppointmentBooking(String doctorname) throws Exception {
		String queryString = "From Doctor d where d.doctorname=" + "\'" + doctorname + "\'";
		List<Doctor> doctorList;
		Session session = HibernateUtil.getSesion();
		Query query = session.createQuery(queryString);
		doctorList = query.list();
		return doctorList.get(0);
	}
	

	/**
	 * getDoctorListForAppointmentBooking
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Doctor> getDoctorListForAppointmentBooking(String department) throws Exception {
		System.out.println("we are in dao");
		String queryString = "From Doctor d where d.department=" + "\'" + department + "\'";
		List<Doctor> doctorList;
		Session session = HibernateUtil.getSesion();
		Query query = session.createQuery(queryString);
		doctorList = query.list();
		return doctorList;
	}

	/**
	 * Patient appointment history is quried by this method in order to confirm
	 * future appointments
	 * 
	 * @param username
	 * @param date
	 * @param time
	 * @return
	 */
	public int getPatientConfirmation(String username, String date, String time) {

		String queryString = "From AppointmentRegister d where bookeddate=" + "\'" + date + "\'" + " and " + time + "="
				+ "\'" + username + "\'";

		Query query = HibernateUtil.getSesion().createQuery(queryString);
		List<AppointmentRegister> list = query.list();

		if (list.size() == 0) {
			return 1;
		}

		else {
			return 0;
		}

	}

	/**
	 * Admin Authentication
	 * 
	 * @param admin
	 * @return
	 */
	public int getAdminauthentication(Admin admin) {
		Logger logger = Logger.getLogger(AuthenticatorDao.class.getName());
		try {
			Session session = HibernateUtil.getSesion();
			Transaction transaction = session.beginTransaction();
			String sql = "From Admin where username=" + "\'" + admin.getUsername() + "\'" + " " + " and password="
					+ "\'" + admin.getPassword() + "\'";

			Query q = session.createQuery(sql);
			@SuppressWarnings("unchecked")
			List<Admin> adminList = q.list();
			transaction.commit();
			session.close();

			if (adminList.size() > 0) {
				return SuccessEnum.success.key();

			} else {
				return FailureEnum.failure.key();
			}
		} catch (Exception e) {
			logger.info("Probelm occured in getAdminauthentication method of ADMINDAO class");
			logger.info(e.getStackTrace());
			return FailureEnum.failure.key();

		}
	}

	/**
	 * Patient Authentication
	 * 
	 * @param username
	 * @return
	 */
	public int getUsernameIdentity(String username) {
		try {
			logger.info("Patient is being authenticated ..");
			Session session = HibernateUtil.getSesion();
			Query query = session.getNamedQuery("findcontact");
			query.setString("contact", username);
			@SuppressWarnings("unchecked")
			List<Patient> userList = query.list();
			if (userList.size() > 0) {

				return FailureEnum.failure.key();
			}

			else {
				return SuccessEnum.success.key();
			}

		} catch (Exception excetion) {
			logger.info("problem in getUsernameIdentity method of PatientDao class");
			logger.info(excetion.getStackTrace());
			return FailureEnum.failure.key();
		}
	}

	/**
	 * Patient list for view service
	 * 
	 * @param userName
	 * @return
	 */
	public List<Patient> getPatietDetails(String userName) {
		try {
			Session session = HibernateUtil.getSesion();
			Query query = session.getNamedQuery("findcontact");
			query.setString("contact", userName);
			@SuppressWarnings("unchecked")
			List<Patient> userList = query.list();
			return userList;

		} catch (Exception excetion) {
			logger.info("problem in getPatietDetails method of PatientDao class");
			logger.info(excetion.getStackTrace());
			return null;
		}

	}

	/**
	 * Doctor authentication method
	 * 
	 * @param doctorId
	 * @return: 1 if succsfull 0 if not.
	 */
	public int getDoctorIdentity(Integer doctorId) {
		try {

			Session session = HibernateUtil.getSesion();
			Query doctorQuery = session.getNamedQuery("doctorauth");
			doctorQuery.setInteger("doctorid", doctorId);
			@SuppressWarnings("unchecked")
			List<Patient> emaiList = doctorQuery.list();

			if (emaiList.size() == SuccessEnum.success.key()) {
				return FailureEnum.failure.key();
			}

			else {
				return SuccessEnum.success.key();
			}

		}

		catch (Exception exception) {
			logger.info("Problem Occured in getDoctorIdentity method of DoctorDao class");
			logger.info(exception.getStackTrace());
			return FailureEnum.failure.key();
		}
	}

	/**
	 * This method authenticates the patient login credentials with registred
	 * patient details.
	 * 
	 * @return 1:If Patient credentials are succesfully verified
	 */
	public int getPatientLoginAuthentication(PatientLogin patientlogin) {

		try {
			Session session = HibernateUtil.getSesion();
			Query patientquery = session.getNamedQuery("findpatient");

			patientquery.setString("contact", patientlogin.getUsername());
			patientquery.setString("password", patientlogin.getPassword());
			@SuppressWarnings("unchecked")
			List<Patient> patientList = patientquery.list();
			session.close();
			if (patientList.size() == 1) {
				return SuccessEnum.success.key();
			} else {
				return FailureEnum.failure.key();
			}
		}

		catch (Exception exception) {
			logger.info("problem in getPatientLoginAuthentication of PatientLoginDao class");
			logger.info(exception.getStackTrace());
			return FailureEnum.failure.key();
		}

	}
}
