package com.application.services.mocktest;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.application.common.AuthenticatorDao;
import com.application.entity.Admin;
import com.application.services.AdminService;

public class AdminServiceTest {
	Admin admin = new Admin();
	AuthenticatorDao adminDao = mock(AuthenticatorDao.class);
	AdminService adminService = new AdminService(admin);

	@Test
	public void testAuthenticateAdminException() {
		adminService.setAdminDao(adminDao);
		when(adminDao.getAdminauthentication(admin)).thenReturn(10);
		assertEquals(10, adminService.authenticateAdmin());
		verify(adminDao, times(1)).getAdminauthentication(admin);
	}
}
