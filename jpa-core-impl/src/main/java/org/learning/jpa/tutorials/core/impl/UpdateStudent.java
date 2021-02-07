package org.learning.jpa.tutorials.core.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.learning.jpa.tutorials.core.impl.entity.StudentEntity;

public class UpdateStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		StudentEntity entity = entityManager.find(StudentEntity.class, 2);
		System.out.println("Student Entity value Before updation");
		System.out.println("Student Id: " + entity.getId());
		System.out.println("Student Name: " + entity.getName());
		System.out.println("Student Age: " + entity.getAge());

		entity.setAge(32);
		System.out.println("Student Entity value After updation");
		System.out.println("Student Id: " + entity.getId());
		System.out.println("Student Name: " + entity.getName());
		System.out.println("Student Age: " + entity.getAge());

		entityManager.getTransaction().commit();

	}

}
