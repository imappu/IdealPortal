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
import com.application.entity.Doctor;
import com.application.enums.SuccessEnum;
import com.application.services.DoctorService;
import com.bean.builder.DoctorBuilder;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/html/doctor")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse) Servlet Controller class for
	 *      Doctor registration. Request type : http Request method:post Thus
	 *      service() method redirects http requests to doPost() method.
	 */
	Logger logger = Logger.getLogger(DoctorController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		try {
			Doctor doctor = new DoctorBuilder().buildDoctor(
					request.getParameter("doctorName"),
					request.getParameter("department"), 
					request.getParameter("qualification"));

			DoctorService doctorService = new DoctorService(doctor);
			doctorService.setDoctorDao(new InsertDaoBuilder().getInsertDao());

			if (doctorService.registerDoctor() == SuccessEnum.success.key()) {
				requestDispatcher = request.getRequestDispatcher("../jsp/doctorsuccess.jsp");
			}

			else {
				requestDispatcher = request.getRequestDispatcher("../jsp/doctorfailure.jsp");
			}
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			logger.info("Problem in doctor controller of DoctorController class");
			logger.info(e.getStackTrace());
			requestDispatcher = request.getRequestDispatcher("../jsp/doctorfailure.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
