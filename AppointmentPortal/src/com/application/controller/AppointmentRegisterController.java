package com.application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.application.entity.AppointmentRegister;
import com.application.entity.Doctor;
import com.application.enums.SuccessEnum;
import com.application.services.AppointmentService;
import com.application.services.DoctorVerifierService;
import com.application.services.PatientConfirmerService;
import com.bean.builder.AppointmentRegisterBuilder;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/html/bookappointment")
public class AppointmentRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse) Servlet Controller class for
	 *      Appointment booking. Request type : http Request method:post Thus
	 *      service() method redirects http requests to doPost() method.
	 */
	Logger logger = Logger.getLogger(AppointmentRegisterController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			String loggedInUser =  request.getSession().getAttribute("username").toString();
			int patientStatus=new PatientConfirmerService().getPatieentConfirmation(loggedInUser, request.getParameter("date"), request.getParameter("timeslot"));
			Doctor selectedDoctor=new DoctorVerifierService().getSelectedDoctorDetails(request.getParameter("doctor"));
			AppointmentRegister appointmentRegister = new AppointmentRegisterBuilder().buildAppointmentRegister(
					request.getParameter("department"),
					request.getParameter("date"), 
					request.getParameter("doctor"),
					selectedDoctor.getDoctorid(),
					request.getParameter("timeslot"),
					loggedInUser);
			
			 
			AppointmentService appointmentService = new AppointmentService(appointmentRegister);
			int result = appointmentService.provideAppointment(loggedInUser);
			RequestDispatcher requestDispatcher;
			 if(patientStatus==0)
				{
				 requestDispatcher = request.getRequestDispatcher("../jsp/failedbook.jsp");					
				}
			 else if (result == SuccessEnum.success.key()) {
				requestDispatcher = request.getRequestDispatcher("../jsp/confirmbook.jsp");
			} else {
				requestDispatcher = request.getRequestDispatcher("../jsp/failedbook.jsp");
			}
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			//logger.error("problem in dopost methos of AppointmentRegisterController class ");
			//logger.error(e.getMessage());
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../jsp/failedbook.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
