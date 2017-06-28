package com.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.application.common.AppointmentSchedular;
import com.application.entity.AppointmentRegister;
import com.application.entity.AppointmentVerifier;
import com.application.entity.Doctor;
import com.application.enums.FailureEnum;
import com.application.enums.SuccessEnum;
import com.hibernateutil.HibernateUtil;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */

public class AppointementVerifierDao {

	AppointmentVerifier appointmentVerifier;
	AppointmentSchedular appointmentSchedular=new AppointmentSchedular();
	Logger logger = Logger.getLogger(AppointementVerifierDao.class.getName());
	
	public AppointementVerifierDao(AppointmentVerifier appointmentVerifier) {
		this.appointmentVerifier = appointmentVerifier;
	}

	/**
	* This method works on appointment register table  to get the time slot information.
	* @param  loggedInUser: Logged in user.
	* @return 1 :Admin is successfully authenticated 0: Admin is not authenticated. 
 	*/
	@SuppressWarnings("unchecked")
	public int getBookedAppointmentsAvaiability(String loggedInUser,String doctorName,int doctorId) throws Exception{
			Query getUnscheduledDoctor;
			List<AppointmentRegister> appointmentRegisterList;
			String forUnscheduledDoctor;
			String selectedTimeslot = appointmentSchedular.getTimeslotFilter(appointmentVerifier);
			Session session = HibernateUtil.getSesion();

			// Check doctors count
			List<Doctor> doctorList = appointmentSchedular.getDoctorDetails(appointmentVerifier);
			
			//If no doctors are added then appointment can not be booked
			if (doctorList != null) {
				if (doctorList.size() == 0) {
					return FailureEnum.failure.key();
				}

			}
			
			
			
				// Check time previous doctor entry and if no entry book appointment and return
				
					forUnscheduledDoctor = "From AppointmentRegister d where d.department=" + "\'"
							+ appointmentVerifier.getDepartment() + "\'" + "" + " and  employeeid="
							+ doctorId + " and   bookeddate=" + "\'"
							+ appointmentVerifier.getBookeddate() + "\'";

					getUnscheduledDoctor = session.createQuery(forUnscheduledDoctor);
					appointmentRegisterList = getUnscheduledDoctor.list();

					if (appointmentRegisterList.size() == 0) {
						appointmentVerifier.setDoctorname(doctorName);
						appointmentVerifier.setEmployeeid(doctorId);
						return SuccessEnum.success.key();
					}

			
			

			// Check doctor for given date and time slots which are free
			
				
					forUnscheduledDoctor = "From AppointmentRegister d where d.department=" + "\'"
							+ appointmentVerifier.getDepartment() + "\'" + " and  employeeid="
							+ doctorId + " and  " + selectedTimeslot + " is null "
							+ " and   bookeddate=" + "\'" + appointmentVerifier.getBookeddate() + "\'";
					getUnscheduledDoctor = session.createQuery(forUnscheduledDoctor);
					appointmentRegisterList = getUnscheduledDoctor.list();

					if (appointmentRegisterList.size() > 0) {
						return SuccessEnum.success.key();
					}
				
			

			session.close();
			return FailureEnum.failure.key();

	

	}

	
}
