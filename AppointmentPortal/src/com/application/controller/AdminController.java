package com.application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.application.daobuilder.AuthenticatorDaoBuilder;
import com.application.entity.Admin;
import com.application.enums.SuccessEnum;
import com.application.services.AdminService;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/html/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse) Servlet Controller class for
	 *      Admin authentication. Request type : http Request method:post Thus
	 *      service() method redirects http requests to doPost() method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		Logger logger = Logger.getLogger(AdminController.class.getName());
		try {
			Admin admin = new com.bean.builder.AdminBuilder().buildAdmin(
					request.getParameter("username"),
					request.getParameter("password"));
			AdminService adminService = new AdminService(admin);
			adminService.setAdminDao(new AuthenticatorDaoBuilder().getAuthenticatorDao());
			
			if (adminService.authenticateAdmin() == SuccessEnum.success.key()) {
				requestDispatcher = request.getRequestDispatcher("adddoctor.html");
			} else {
				requestDispatcher = request.getRequestDispatcher("../jsp/adminfailed.jsp");
			}
			requestDispatcher.forward(request, response);
		}

		catch (Exception e) {
			logger.info("Problem in doPost method of AdminController class");
			logger.info(e.getStackTrace());
			requestDispatcher = request.getRequestDispatcher("../jsp/adminfailed.jsp");
			requestDispatcher.forward(request, response);

		}
	}
}
