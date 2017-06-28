package com.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.common.AppointmentBooker;
import com.application.common.AppointmentSchedular;
import com.application.entity.AppointmentRegister;
import com.application.entity.Doctor;
import com.application.enums.FailureEnum;
import com.application.enums.SuccessEnum;
import com.hibernateutil.HibernateUtil;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */

public class AppointementRegisterDao {
	AppointmentSchedular appointmentSchedular=new AppointmentSchedular();
	AppointmentRegister appointmentRegister;
	Logger logger = Logger.getLogger(AppointementRegisterDao.class.getName());
	AppointmentBooker appointmentBooker=new AppointmentBooker();
	public AppointementRegisterDao(AppointmentRegister appointementRegister) {
		this.appointmentRegister = appointementRegister;
	}

	/**
	 * This method works on appointment register table to get the time slot
	 * information.
	 * 
	 * @param loggedInUser:Logged
	 *            in user.
	 * @return: 1:If time slot is available for given date
	 * 			 0: If time slot is not available for given date
	 */
	@SuppressWarnings("unchecked")
	public int getBookedAppointments(String loggedInUser) throws Exception{
			Transaction updateTransaction;
			String forUnscheduledDoctorQuery;
			Query getUnscheduledDoctor;
			List<AppointmentRegister> appointmentRegisterList;
			String forUnscheduledDoctor;
			String forScheduledDoctor2;
			Query getscheduledDoctor2;
			List<AppointmentRegister> appointmentRegisterList2;
			Query getUnscheduledDoctorQuery;

			String selectedTimeslot = appointmentBooker.getTimeslotFilter(appointmentRegister);
			Session session = HibernateUtil.getSesion();

			// Check doctors count
			List<Doctor> doctorList = appointmentBooker.getDoctorRowcount(appointmentRegister);
			
			if (doctorList != null) {
				if (doctorList.size() == 0) {
					return FailureEnum.failure.key();
				}

			}
			
			// Check time previous doctor entry and if no entry book appointment and return
			
					forUnscheduledDoctor = "From AppointmentRegister d where d.department=" + "\'"
							+ appointmentRegister.getDepartment() + "\'" + "" + " and  employeeid="
							+ appointmentRegister.getEmployeeid()+ " and   bookeddate=" + "\'"
							+ appointmentRegister.getBookeddate() + "\'";

					getUnscheduledDoctor = session.createQuery(forUnscheduledDoctor);
					appointmentRegisterList = getUnscheduledDoctor.list();

					if (appointmentRegisterList.size() == 0) {
						appointmentBooker.saveAppoitmentDetails(appointmentRegister);
						return SuccessEnum.success.key();
					}

				
			
			// Check doctor for given date and time slots which are free
			
					forScheduledDoctor2 = "From AppointmentRegister d where d.department=" + "\'"
							+ appointmentRegister.getDepartment() + "\'" + " and  employeeid="
							+ appointmentRegister.getEmployeeid() + " and  " + selectedTimeslot + " is null "
							+ " and   bookeddate=" + "\'" + appointmentRegister.getBookeddate() + "\'";
					getscheduledDoctor2 = session.createQuery(forScheduledDoctor2);
					appointmentRegisterList2 = getscheduledDoctor2.list();

					if (appointmentRegisterList2.size() > 0) {
						updateTransaction = session.beginTransaction();
						forUnscheduledDoctorQuery = "update AppointmentRegister set " + selectedTimeslot + "=" + "\'"
								+ loggedInUser + "\'" + " where employeeid=:employeeid" + " and   bookeddate=" + "\'"
								+ appointmentRegister.getBookeddate() + "\'";
						getUnscheduledDoctorQuery = session.createQuery(forUnscheduledDoctorQuery);
						getUnscheduledDoctorQuery.setInteger("employeeid", appointmentRegister.getEmployeeid());
						getUnscheduledDoctorQuery.executeUpdate();
						updateTransaction.commit();
						return SuccessEnum.success.key();
					}
			
		
			session.close();
			return FailureEnum.failure.key();

		

	}

}
