package com.application.services;

import org.apache.log4j.Logger;

import com.application.common.AuthenticatorDao;
import com.application.entity.Admin;
import com.application.enums.FailureEnum;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class AdminService {

	Admin admin;
	AuthenticatorDao adminDao;
	/**
	 * AdminService contructor.
	 * AdminDao instance is constructor injected. 
	 * @param admin
	 */
	public AdminService(Admin admin) {
		super();
		this.admin = admin;
	}
/**
 * The method using admin dao authenticates the admin enyity.
 * @return 1 :Admin is successfully authenticated 0: Admin is not authenticated. 
 */
	public int authenticateAdmin() {
		Logger logger = Logger.getLogger(AdminService.class.getName());
		logger.info("Admin service is invoked..");
		try {
			//adminDao=new AuthenticatorDao();
			return adminDao.getAdminauthentication(admin);
		} catch (Exception e) {
			logger.info("Problem in authenticateAdmin method of AdminService class");
			logger.info(e.getStackTrace());
			return FailureEnum.failure.key();
		}
	}

	
	public void setAdminDao(AuthenticatorDao adminDao) {
		this.adminDao = adminDao;
	}
}
