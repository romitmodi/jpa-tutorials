package org.learning.jpa.tutorials.core.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.learning.jpa.tutorials.core.impl.entity.Library;
import org.learning.jpa.tutorials.core.impl.entity.Student;

public class OneToOneMapppingExample {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student s1 = new Student();
		s1.setName("Romit Modi");
		s1.setFees(100);

		Student s2 = new Student();
		s2.setName("Rajat Modi");
		s2.setFees(100);

		Library lib1 = new Library("Data Structure", s1);
		Library lib2 = new Library("Data Structure using Java", s2);

		entityManager.getTransaction().begin();

		entityManager.persist(s1);
		entityManager.persist(s2);

		entityManager.persist(lib1);
		entityManager.persist(lib2);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
