package com.bean.builder;

import org.apache.log4j.Logger;

import com.application.entity.AppointmentRegister;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
public class AppointmentRegisterBuilder {

	/**
	 * Builds AppointmentRegister instance with setters injection.
	 * 
	 * @param department
	 * @param bookedDate
	 * @param slot
	 * @param loggenUser
	 * @return AppointmentRegister
	 */
	public AppointmentRegister buildAppointmentRegister(String department, String bookedDate,String doctorname,int doctorid, String slot,
			String loggenUser) {
		AppointmentRegister appointmentRegister = new AppointmentRegister();
		Logger logger = Logger.getLogger(AppointmentRegisterBuilder.class.getName());
		try {
			appointmentRegister.setDepartment(department);
			appointmentRegister.setBookeddate(bookedDate);
			appointmentRegister.setEmployeeid(doctorid);
			appointmentRegister.setDoctorname(doctorname);

			switch (slot) {

			case "slot01":
				appointmentRegister.setSlot01(loggenUser);
				break;
			case "slot02":
				appointmentRegister.setSlot02(loggenUser);
				break;
			case "slot03":
				appointmentRegister.setSlot03(loggenUser);
				break;
			case "slot04":
				appointmentRegister.setSlot04(loggenUser);
				break;

			default:
				;

			}
			return appointmentRegister;
		} catch (Exception e) {
			logger.info("Problem in buildAppointmentRegister method of AppointmentRegisterBuilder class");
			logger.info(e.getStackTrace());
			return appointmentRegister;
		}
	}
}
