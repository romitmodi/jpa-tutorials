package org.learning.jpa.tutorials.core.impl.inheritance.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleTableInheritence {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		ActiveEmployee activeEmployee = new ActiveEmployee("Romit Modi", 8, 2500000);

		RetiredEmployee employee = new RetiredEmployee("Papa", 25000);

		entityManager.persist(activeEmployee);
		entityManager.persist(employee);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
