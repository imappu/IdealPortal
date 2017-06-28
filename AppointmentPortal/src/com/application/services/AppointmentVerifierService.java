package com.application.services;
import org.apache.log4j.Logger;

import com.application.entity.AppointmentVerifier;
import com.application.enums.FailureEnum;
import com.hibernate.dao.AppointementVerifierDao;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class AppointmentVerifierService {

	AppointmentVerifier appointmentVerifier;

	/**
	 * AppointmentService contructor.
	 * AppointmentRegister instance is constructor injected. 
	 * @param AppointmentRegister
	 */
		public void setAppointmentVerifier(AppointmentVerifier appointmentVerifier) {
		this.appointmentVerifier = appointmentVerifier;
	}

	/**
	 * 
	 * This method works on appointment register table using appointment dao classes to get the time slot inforamation. 
	 * @param loggedInUser:logged in  user. 
	 * @return: 1:If time slot is available for given date   
	 * 			0: If time slot is not available for given date 
	 */
	public int provideAppointmentAvailability(String loggedInUser,String doctorName,int doctorId) {
		Logger logger = Logger.getLogger(AppointmentVerifierService.class.getName());
		try {
			return new AppointementVerifierDao(appointmentVerifier).getBookedAppointmentsAvaiability(loggedInUser,doctorName,doctorId);
		} catch (Exception exception) {
			logger.info("Problem in provideAppointmentAvailability method of AppointmentVerifier class");
			logger.info(exception.getStackTrace());
			return FailureEnum.failure.key();
		}

	}

	public AppointmentVerifierService(AppointmentVerifier appointmentVerifier) {
		this.appointmentVerifier = appointmentVerifier;
	}
}
