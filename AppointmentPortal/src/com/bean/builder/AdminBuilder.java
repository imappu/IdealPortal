package com.bean.builder;

import com.application.entity.Admin;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class AdminBuilder {

	/**
	 * Builds the Admin instance using admin username and admin password.
	 * @param userName
	 * @param password
	 * @return Admin
	 */
	public Admin buildAdmin(String userName, String password) {
		Admin admin = new Admin(userName, password);
		return admin;
	}
}
