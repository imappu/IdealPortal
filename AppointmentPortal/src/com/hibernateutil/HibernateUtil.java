package com.hibernateutil;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.application.controller.AdminController;

/**
 * @author Apparay Shakapure <AS052304>
 * @version 1.0
 * @since 1.0
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	private static ServiceRegistry serviceRegistry;

	/**
	 * It is hibernate utility class. It builds sessionfactory instance using
	 * service registry mechanism. It returns session instance from session factory
	 * instance.
	 * 
	 * @return
	 */
	public static Session getSesion() {
		Logger logger = Logger.getLogger(AdminController.class.getName());
		Session session=null;
		try {
			Configuration configuration = new Configuration().configure("com/hibernateutil/hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();

			return session;
		} catch (Exception e) {
			logger.info("Problem in getSesion method of HibernateUtil class ");
			logger.info(e.getStackTrace());
			return session;
		}
	}
}
