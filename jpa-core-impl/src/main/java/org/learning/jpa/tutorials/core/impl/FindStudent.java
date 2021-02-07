package org.learning.jpa.tutorials.core.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.learning.jpa.tutorials.core.impl.entity.StudentEntity;

public class FindStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StudentEntity entity = entityManager.find(StudentEntity.class, 1);
		
		System.out.println(entity.toString());

	}

}
