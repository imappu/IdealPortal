package com.application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.application.entity.AppointmentRegister;
import com.application.entity.Patient;
import com.application.services.PatientRegisterServie;
import com.application.services.ViewerService;
/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
@WebServlet("/html/view")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * Servlet Controller class to view Appointment Register. 
	 * Request type : http 
	 * Request method:post 
	 * Thus service() method redirects http requests to doPost() method.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loggedinuser = "";
		RequestDispatcher requestDispatcher;

		try {
			loggedinuser=request.getSession().getAttribute("username").toString();
				List<Patient> patientList = new PatientRegisterServie().getPatientDetailsForView(loggedinuser);
				ViewerService viewerService=new ViewerService();
				List<AppointmentRegister> appointmentlist = viewerService.viewAppointments(loggedinuser);

				if (appointmentlist != null) {
					if (appointmentlist.size() > 0)

					{
						request.setAttribute("list", appointmentlist);
						request.setAttribute("patientDetails", patientList);
						requestDispatcher = request.getRequestDispatcher("../jsp/view.jsp");

					}

					else {
						requestDispatcher = request.getRequestDispatcher("../jsp/viewerror.jsp");
					}
					requestDispatcher.forward(request, response);
				} 
				
				else {
					requestDispatcher = request.getRequestDispatcher("../jsp/viewerror.jsp");
					requestDispatcher.forward(request, response);
				}
			}
		

		catch (Exception e) {
			System.out.println("Problem occured in doget method  of view request");
			requestDispatcher = request.getRequestDispatcher("../jsp/viewerror.jsp");
			requestDispatcher.forward(request, response);
			System.out.println(e.getCause());
		}
	}

}
