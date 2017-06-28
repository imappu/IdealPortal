package com.bean.builder;

import org.apache.log4j.Logger;

import com.application.entity.AppointmentVerifier;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
public class AppointmentVerifierBuilder {

	/**
	 * Builds AppointmentRegister instance with setters injection.
	 * 
	 * @param department
	 * @param bookedDate
	 * @param slot
	 * @param loggenUser
	 * @return AppointmentRegister
	 */
	public AppointmentVerifier buildAppointmentVerifier(String department, String bookedDate, String slot,
			String loggenUser) {

		Logger logger = Logger.getLogger(AppointmentVerifierBuilder.class.getName());
		AppointmentVerifier appointmentVerifier = new AppointmentVerifier();
		try {
			appointmentVerifier.setDepartment(department);
			appointmentVerifier.setBookeddate(bookedDate);

			switch (slot) {
			case "slot01":
				appointmentVerifier.setSlot01(loggenUser);
				break;
			case "slot02":
				appointmentVerifier.setSlot02(loggenUser);
				break;
			case "slot03":
				appointmentVerifier.setSlot03(loggenUser);
				break;
			case "slot04":
				appointmentVerifier.setSlot04(loggenUser);
				break;

			default:
				;

			}
			return appointmentVerifier;

		} catch (Exception e) {
			logger.info(e.getStackTrace());
			logger.info("Problem in buildAppointmentVerifier method of AppointmentVerifierBuilder class");
			return  appointmentVerifier;
		}
		
	}
}
