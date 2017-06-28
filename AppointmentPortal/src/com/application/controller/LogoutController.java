package com.application.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/html/logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LogoutController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getSession().invalidate();
			response.sendRedirect("plogin.html");
		} catch (Exception e) {
			logger.info("Problem in doPost method of LogoutController");
			logger.info(e.getStackTrace());

		}
	}

}
