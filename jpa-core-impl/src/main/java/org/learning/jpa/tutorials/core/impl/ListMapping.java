package org.learning.jpa.tutorials.core.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.learning.jpa.tutorials.core.impl.entity.Address;
import org.learning.jpa.tutorials.core.impl.entity.Employee;

// Structure of Data stored in database in case of List & Set are same.
public class ListMapping {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Address address1 = new Address();
		address1.setState("UP");
		address1.setCity("Jhansi");
		address1.setPincode(284002);

		Address address2 = new Address();
		address2.setState("Haryana");
		address2.setCity("Gurugram");
		address2.setPincode(122005);

		Employee employee1 = new Employee();
		//employee1.setEmpId(1);
		employee1.setEmpName("Rajat Modi");
		employee1.getAddress().add(address1);

		Employee employee2 = new Employee();
		//employee2.setEmpId(2);
		employee2.setEmpName("Romit Modi");
		employee2.getAddress().add(address2);

		entityManager.persist(employee1);
		entityManager.persist(employee2);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
