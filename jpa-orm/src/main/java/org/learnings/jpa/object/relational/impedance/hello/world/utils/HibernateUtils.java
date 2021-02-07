package org.learnings.jpa.object.relational.impedance.hello.world.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactoryForHibernate5();

	private static SessionFactory buildSessionFactoryForHibernate4() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
		return configuration.buildSessionFactory(serviceRegistry.applySettings(configuration.getProperties()).build());
	}

	private static SessionFactory buildSessionFactoryForHibernate5() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
		        .build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		return metadata.getSessionFactoryBuilder().build();
	}

	public static SessionFactory getInstance() {
		return SESSION_FACTORY;
	}
}
