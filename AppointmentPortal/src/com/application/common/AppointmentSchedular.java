package com.application.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.application.entity.AppointmentRegister;
import com.application.entity.AppointmentVerifier;
import com.application.entity.Doctor;
import com.application.enums.FailureEnum;
import com.hibernateutil.HibernateUtil;

public class AppointmentSchedular {
	Logger logger = Logger.getLogger(AppointmentSchedular.class.getName());

	public String getTimeslotFilter(AppointmentVerifier appointmentVerifier) {
		try {
			if (appointmentVerifier.getSlot01() != null) {
				return "slot01";
			}

			if (appointmentVerifier.getSlot02() != null) {
				return "slot02";
			}

			if (appointmentVerifier.getSlot03() != null) {
				return "slot03";
			}

			if (appointmentVerifier.getSlot04() != null) {
				return "slot04";
			}

			return "";
		}

		catch (Exception e) {
			logger.info("Problem in getTimeslotFilter method of AppointementVerifierDao ");
			logger.info(e.getStackTrace());
			return "";
		}

	}
	/**
	 * Provides the row count of Appointment register tables 
	 * @return: returns the size of array list
	 */
	public int getAppointerRowcount(AppointmentVerifier appointmentVerifier) {
		try {
			Session session = HibernateUtil.getSesion();
			Query emailquery = session.getNamedQuery("appoint");
			@SuppressWarnings("unchecked")
			List<AppointmentRegister> emaiList = emailquery.list();
			System.out.println(emaiList.size());
			return emaiList.size();

		}

		catch (Exception exception) {
			logger.info("Problem in getAppointerRowcount method of  AppointementVerifierDao");
			logger.info(exception.getStackTrace());

			return FailureEnum.failure.key();
		}
	}
	
	/**
	 * queries doctor tables and returns the list
	 * @return :List<Doctor> list 
	 */
		@SuppressWarnings("unchecked")
		public List<Doctor> getDoctorDetails(AppointmentVerifier appointmentVerifier) {
			List<Doctor> list = null;
			try {
				Session session = HibernateUtil.getSesion();
				String queryString = "From Doctor d where d.department=" + "\'" + appointmentVerifier.getDepartment()
						+ "\'";
				Query query = session.createQuery(queryString);
				list = query.list();
				return list;
			} catch (Exception exception) {

				logger.info("Problem in getDoctorDetails method of  AppointementVerifierDao");
				logger.info(exception.getStackTrace());
				return list;
			}

		}
}

