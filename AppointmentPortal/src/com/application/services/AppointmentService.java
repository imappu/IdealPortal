package com.application.services;

import org.apache.log4j.Logger;

import com.application.entity.AppointmentRegister;
import com.application.enums.FailureEnum;
import com.hibernate.dao.AppointementRegisterDao;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class AppointmentService {

	AppointmentRegister appointmentRegister;

	/**
	 * AppointmentService contructor.
	 * AppointmentRegister instance is constructor injected. 
	 * @param AppointmentRegister
	 */
	public AppointmentService(AppointmentRegister appointementRegister) {
		this.appointmentRegister = appointementRegister;
	}

	/**
	 * This method works on appointment register table using appointment dao classes to get the time slot information. 
	 *  @param loggedInUser:logged in  user. 
	 * @return: 1:If time slot is available for given date 0: If time slot is not available for given date 
	 */
	 
	public int provideAppointment(String loggedInUser) {
		Logger logger = Logger.getLogger(AppointmentService.class.getName());
		try {
			return new AppointementRegisterDao(appointmentRegister).getBookedAppointments(loggedInUser);
		} catch (Exception exception) {
			logger.info("Problem in provideAppointment method of AppointmentService class");
			logger.info(exception.getStackTrace());
			return FailureEnum.failure.key();
		}

	}
	public void setAppointmentRegister(AppointmentRegister appointmentRegister) {
		this.appointmentRegister = appointmentRegister;
	}
}
