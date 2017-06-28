package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.application.entity.AppointmentVerifier;
import com.application.entity.Doctor;
import com.application.enums.SuccessEnum;
import com.application.services.AppointmentVerifierService;
import com.application.services.DoctorVerifierService;
import com.application.services.PatientConfirmerService;
import com.bean.builder.AppointmentVerifierBuilder;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/time")
public class TimeslotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger logger = Logger.getLogger(AppointmentVerifierService.class.getName());
		String loggedInUser = request.getSession().getAttribute("username").toString();
		try {
			PrintWriter printWriter = response.getWriter();
			String department = request.getParameter("department");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String doctorName=request.getParameter("doctor");
			Doctor selectedDoctor=new DoctorVerifierService().getSelectedDoctorDetails(doctorName);
			int patientStatus=new PatientConfirmerService().getPatieentConfirmation(loggedInUser, date, time);
			
			if (department == "") {
				printWriter.write("Please select Department");
			} else if (date == "") {
				printWriter.write("Please select date");
			} else if (time == "") {
				printWriter.write("Please select timeslot");
			}
			else if(doctorName.equals("select"))
			{	
				printWriter.write("Please select doctor name");
				
			}
			else if(patientStatus==0)
			{
				printWriter.write("Sorry..You have already booked an appointment for this time slot"+
									" ..Please try again with diffrent timeslots or dates..!!");
			}
			
			else if(selectedDoctor==null) {
				printWriter.write("Sorry..The selected Doctor is not available..");
			}
			else {
				
				AppointmentVerifier appointmentVerifier = new AppointmentVerifierBuilder()
						.buildAppointmentVerifier(department, date, time, loggedInUser);
				
				AppointmentVerifierService appointmentVerifierService = new AppointmentVerifierService(
						appointmentVerifier);
				int result = appointmentVerifierService.provideAppointmentAvailability(loggedInUser,doctorName,selectedDoctor.getDoctorid());
				
				if (result == SuccessEnum.success.key()) {
					printWriter.write("Congratulations..!!" + " Slots are available..Please book the Appointment");
				} else {

					printWriter.write("Sorry..!!" + " Slots are not available.."
							+ " Please try again with diffrent slots or dates or with diffrent doctors");
				}

			}
		} catch (Exception e) {
			logger.info("problem in doPost method of Timeslot controller class");
			logger.info(e.getCause());
		}
	}

}