package com.application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.common.AuthenticatorDao;
import com.application.entity.Doctor;
import com.application.services.DoctorVerifierService;

/**
 * Servlet implementation class DoctorVerifierController
 */
@WebServlet("/html/getdoctorlist")
public class DoctorVerifierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String department = request.getParameter("department");
			DoctorVerifierService doctorVerifierService = new DoctorVerifierService();
			doctorVerifierService.setAuthenticatorDao(new AuthenticatorDao());
			List<Doctor> doctorList = doctorVerifierService.getDoctorListForAppointmentBooking(department);
			RequestDispatcher requestDispatcher;
			if (doctorList.size() == 0) {
				requestDispatcher = request.getRequestDispatcher("../jsp/nodoctor.jsp");

			} else {
				request.setAttribute("doctorlist", doctorList);
				request.setAttribute("department", department);
				requestDispatcher = request.getRequestDispatcher("appointment.jsp");
			}
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}