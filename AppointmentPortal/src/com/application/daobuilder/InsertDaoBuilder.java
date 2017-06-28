package com.application.daobuilder;

import com.application.common.InsertDao;

public class InsertDaoBuilder {

	InsertDao insertDao;

	public InsertDao getInsertDao() {
		if (insertDao == null) {
			insertDao = new InsertDao();
		}
		return insertDao;
	}
}
