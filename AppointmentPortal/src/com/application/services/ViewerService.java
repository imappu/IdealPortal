package com.application.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.application.entity.AppointmentRegister;
import com.hibernate.dao.ViewAppointmentsDao;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class ViewerService {

	
	/**
	 * This method returns List of appointments which are booked by current patient.
	 * @param loggedInUser :Loggedn in user.
	 * @return				:List<AppointmentRegister> which contains the list of all the appointments booked by present user. 
	 * @throws Exception :The exception is handeled at controller classes using try cath block.
	 */
	public List<AppointmentRegister> viewAppointments(String loggedInUser) throws Exception {

		List<AppointmentRegister> appointmentRegisterList = null;
		Logger logger = Logger.getLogger(ViewerService.class.getName());
		try {
			ViewAppointmentsDao viewAppointmentsDao = new ViewAppointmentsDao();
			appointmentRegisterList = viewAppointmentsDao.viewAppointments(loggedInUser);
			return appointmentRegisterList;
		} 
		
		
		catch (Exception e) {
			logger.info("Problem in viewAppointments method of ViewerService");
			logger.info(e.getStackTrace());
			return appointmentRegisterList;
		}
	}
}
