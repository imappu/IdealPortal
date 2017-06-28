package com.application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.application.daobuilder.InsertDaoBuilder;
import com.application.enums.SuccessEnum;
import com.application.interfaces.IPatient;
import com.application.services.PatientRegisterServie;
import com.bean.builder.PatientRegisterBuilder;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/html/Register")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(RegisterController.class.getName());

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse) Servlet Controller class Patient
	 *      Register. Request type : http Request method:post Thus service() method
	 *      redirects http requests to doPost() method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		int result;

		IPatient patient = new PatientRegisterBuilder().buildPatientRegister(
				request.getParameter("firstname"),
				request.getParameter("lastname"),
				request.getParameter("password"), 
				request.getParameter("contact"),
				request.getParameter("email"),
				request.getParameter("dob"), 
				request.getParameter("gender"),
				request.getParameter("address"));
		
		PatientRegisterServie patientRegisterServie = new PatientRegisterServie(patient);
		patientRegisterServie.setInsertDao(new InsertDaoBuilder().getInsertDao());

		try {
			result = patientRegisterServie.registerPatient();
			if (result == SuccessEnum.success.key()) {

				requestDispatcher = request.getRequestDispatcher("/jsp/registersuccess.jsp");
			} else {
				requestDispatcher = request.getRequestDispatcher("/jsp/registererror.jsp");
			}
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			logger.info("problem in doPost method of RegisterController class ");
			logger.info(e.getStackTrace());
			requestDispatcher = request.getRequestDispatcher("/jsp/registererror.jsp");
			requestDispatcher.forward(request, response);

		}

	}

}
