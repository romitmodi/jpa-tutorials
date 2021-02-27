package org.learning.jpa.tutorials.core.impl.message.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.learning.jpa.tutorials.core.impl.message.model.Message;

public class Question1Client {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		updateMessage(entityManager);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void saveMessage(EntityManager entityManager) {
		Message message = new Message("Hello World!");
		entityManager.persist(message);
	}
	
	private static void updateMessage(EntityManager entityManager) {
		Message message=entityManager.find(Message.class, 1);
		message = entityManager.merge(message);
		entityManager.detach(message);
		entityManager.remove(message);
		message=entityManager.merge(message);
		System.out.println(entityManager.contains(message));
	}
}
