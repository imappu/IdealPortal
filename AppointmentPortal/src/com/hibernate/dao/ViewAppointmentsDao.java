package com.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.application.entity.AppointmentRegister;
import com.hibernateutil.HibernateUtil;
/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class ViewAppointmentsDao {
	Logger logger = Logger.getLogger(ViewAppointmentsDao.class.getName());
	/**
	 * This method queries the appointmentregister table and provides the list of appointments.
	 * @param loggedInUser: Logged in user
	 * @return List<AppointmentRegister>:Provides the list of appointments booked by patient.
	 * @throws Exception 
	 */
	public List<AppointmentRegister> viewAppointments(String loggedInUser) throws Exception {
		Session session = HibernateUtil.getSesion();
		Query query = session.createQuery("From AppointmentRegister where slot01=:slot01 or slot02=:slot02 or slot03=:slot03 or slot04=:slot04 ");
		query.setString("slot01", loggedInUser);
		query.setString("slot02", loggedInUser);
		query.setString("slot03", loggedInUser);
		query.setString("slot04", loggedInUser);

		@SuppressWarnings("unchecked")
		List<AppointmentRegister> appointmentRegister = query.list();
		session.close();

			if (appointmentRegister != null) {
				processAppointmentList(appointmentRegister, loggedInUser);
			}
			return appointmentRegister;
		
	}

	public void processAppointmentList(List<AppointmentRegister> appointmentsList, String loggedInUser)
			throws Exception {
		
		for (int appointmentNumber = 0; appointmentNumber < appointmentsList.size(); appointmentNumber++) {
			
				if (appointmentsList.get(appointmentNumber).getSlot01() != null
						&& !(appointmentsList.get(appointmentNumber).getSlot01().equals(loggedInUser))) {
					appointmentsList.get(0).setSlot01("--");
				}

				if (appointmentsList.get(appointmentNumber).getSlot02() != null
						&& !(appointmentsList.get(appointmentNumber).getSlot02().equals(loggedInUser))) {
					appointmentsList.get(0).setSlot02("--");
				}

				if (appointmentsList.get(appointmentNumber).getSlot03() != null
						&& !(appointmentsList.get(appointmentNumber).getSlot03().equals(loggedInUser))) {
					appointmentsList.get(0).setSlot03("--");
				}

				if (appointmentsList.get(appointmentNumber).getSlot04() != null
						&& !(appointmentsList.get(appointmentNumber).getSlot04().equals(loggedInUser))) {
					appointmentsList.get(0).setSlot04("--");
				}
			
		}

	}

}