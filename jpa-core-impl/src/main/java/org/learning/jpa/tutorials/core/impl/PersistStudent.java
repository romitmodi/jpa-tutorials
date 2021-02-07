package org.learning.jpa.tutorials.core.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.learning.jpa.tutorials.core.impl.entity.StudentEntity;

public class PersistStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		StudentEntity studentEntity1 = new StudentEntity(1, "Romit Modi", 31);
		StudentEntity studentEntity2 = new StudentEntity(2, "Rajat Modi", 33);
		StudentEntity studentEntity3 = new StudentEntity(3, "Rajat Modi", 33);
		
		entityManager.persist(studentEntity1);
		entityManager.persist(studentEntity2);
		entityManager.persist(studentEntity3);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
