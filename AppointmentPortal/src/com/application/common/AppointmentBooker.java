package com.application.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.AppointmentRegister;
import com.application.entity.Doctor;
import com.application.enums.FailureEnum;
import com.application.enums.SuccessEnum;
import com.hibernateutil.HibernateUtil;

public class AppointmentBooker {
	Logger logger = Logger.getLogger(AppointmentBooker.class.getName());
	/**
	 * Filters the time slot for appointment Register class
	 * @param appointmentRegister
	 * @return: a valid time slot from given appointment register object.
	 */
	public String getTimeslotFilter(AppointmentRegister appointmentRegister) {
		try {
			if (appointmentRegister.getSlot01() != null) {
				return "slot01";
			}

			if (appointmentRegister.getSlot02() != null) {
				return "slot02";
			}

			if (appointmentRegister.getSlot03() != null) {
				return "slot03";
			}

			if (appointmentRegister.getSlot04() != null) {
				return "slot04";
			}

			return "";
		} catch (Exception e) {
			logger.info("Problem in getTimeslotFilter method of AppointmentBooker ");
			logger.info(e.getStackTrace());
			return "";
		}
	}
/**
 * Provides existing appointment list.
 * @param appointmentRegister
 * @return :size of arraylist of appointmentRegister list.
 */
	public int getAppointerRowcount(AppointmentRegister appointmentRegister) {
		try {
			Session session = HibernateUtil.getSesion();
			Query emailquery = session.getNamedQuery("appoint");
			@SuppressWarnings("unchecked")
			List<AppointmentRegister> emaiList = emailquery.list();
			return emaiList.size();

		}

		catch (Exception exception) {
			logger.info("Problem in getAppointerRowcount method of  AppointementRegisterDao");
			logger.info(exception.getStackTrace());
			return 0;
		}
	}
/**
 * Saves the appointment register deatils in register entity table
 * @param appointmentRegister
 * @return
 */
	public int saveAppoitmentDetails(AppointmentRegister appointmentRegister) {
		try {
			Session session = HibernateUtil.getSesion();
			Transaction transaction = session.beginTransaction();
			session.save(appointmentRegister);
			transaction.commit();
			session.close();
			return SuccessEnum.success.key();
		}

		catch (Exception e) {
			logger.info("Problem in saveAppoitmentDeatils method of  AppointementRegisterDao");
			logger.info(e.getStackTrace());
			return FailureEnum.failure.key();
		}
	}

	/**
	 * Provides existing doctor list in doctorentity table for given department.
	 * @param appointmentRegister
	 * @return:List<Doctor> from doctor entity table.
	 */
	@SuppressWarnings("unchecked")
	public List<Doctor> getDoctorRowcount(AppointmentRegister appointmentRegister) {
		List<Doctor> list = null;
		try {
			System.out.println("department is "+appointmentRegister.getDepartment());
			Session session = HibernateUtil.getSesion();
			String queryString = "From Doctor d where d.department=" + "\'" + appointmentRegister.getDepartment()
					+ "\'";
			Query query = session.createQuery(queryString);
			list = query.list();
			return list;
		} catch (Exception exception) {
			logger.info("Problem in getDoctorDetails method of  AppointementRegisterDao");
			logger.info(exception.getStackTrace());
			return list;
		}

	}
	
	

}
