package org.learnings.jpa.object.relational.impedance.client.onetoone;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.onetoone.Customer;
import org.learnings.jpa.object.relational.impedance.model.onetoone.Passport;

public class OneToOneClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Passport passport = new Passport("K2490351", null);
		Customer customer = new Customer("Romit Modi", passport);

		session.persist(customer);

		session.getTransaction().commit();
		session.close();

	}

}
