package com.application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.application.daobuilder.AuthenticatorDaoBuilder;
import com.application.entity.PatientLogin;
import com.application.enums.SuccessEnum;
import com.application.services.PatientLoginService;
import com.bean.builder.PatientLoginBuilder;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/html/plogin")
public class PatientLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher = null;
	Logger logger = Logger.getLogger(PatientLoginController.class.getName());

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse) Servlet Controller class for
	 *      Patient Login . Request type : http Request method:post Thus service()
	 *      method redirects http requests to doPost() method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
						HttpSession httpSession = request.getSession(true);
			if (httpSession != null) {
				httpSession.setAttribute("username", request.getParameter("username"));
			}

			PatientLogin patientlogin = new PatientLoginBuilder().buildPatientLogin(
										request.getParameter("username"),
										request.getParameter("password"));
			PatientLoginService patientLoginService=new PatientLoginService(patientlogin);
			patientLoginService.setPatientLoginDao(new AuthenticatorDaoBuilder().getAuthenticatorDao());
			int authenticationId = patientLoginService.getAuthentication();
			
			//DoctorVerifierService doctorVerifierService=new DoctorVerifierService();
			//doctorVerifierService.setAuthenticatorDao(new AuthenticatorDao());
			//List<Doctor> doctorList=doctorVerifierService.getDoctorListForAppointmentBooking(department);
			
			
			
			if (authenticationId == SuccessEnum.success.key()) {
				requestDispatcher = request.getRequestDispatcher("patienthome.html");
			}

			else {
				requestDispatcher = request.getRequestDispatcher("../jsp/logindenied.jsp");
			}
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			logger.info("Problem in doPost Method of   page PatientLoginController class");
			logger.info(e.getStackTrace());
			requestDispatcher = request.getRequestDispatcher("../jsp/logindenied.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}