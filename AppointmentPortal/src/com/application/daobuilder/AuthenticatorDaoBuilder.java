package com.application.daobuilder;

import com.application.common.AuthenticatorDao;

public class AuthenticatorDaoBuilder {

	AuthenticatorDao authenticatorDao;

	public AuthenticatorDao getAuthenticatorDao() {
		if (authenticatorDao == null) {
			authenticatorDao = new AuthenticatorDao();
		}
		return authenticatorDao;
	}
}
