package org.learning.jpa.tutorials.core.impl.OneToMany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyMapppingExample {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student s1 = new Student();
		s1.setName("Romit Modi");
		s1.setFees(100);

		Library lib1 = new Library("Data Structure");
		Library lib2 = new Library("Data Structure using Java");
		s1.setBooksIssued(new ArrayList<Library>());
		s1.getBooksIssued().add(lib1);
		s1.getBooksIssued().add(lib2);

		entityManager.getTransaction().begin();

		entityManager.persist(lib1);
		entityManager.persist(lib2);
		
		entityManager.persist(s1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
