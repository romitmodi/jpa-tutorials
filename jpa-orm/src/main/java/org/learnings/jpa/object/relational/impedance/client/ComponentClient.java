package org.learnings.jpa.object.relational.impedance.client;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.component.Address;
import org.learnings.jpa.object.relational.impedance.model.component.Person;

public class ComponentClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Address address = new Address("Nazai Bazar", "Jhansi", "284002");
		Person person = new Person("Romit", address);
		session.save(person);
		
		session.getTransaction().commit();
		session.close();
	}

}
