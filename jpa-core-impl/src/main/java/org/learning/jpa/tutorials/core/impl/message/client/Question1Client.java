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
		Message message =entityManager.find(Message.class, 1);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		entityManager1.getTransaction().begin();
		Message message1 =entityManager1.find(Message.class, 1);
		
		System.out.println(message.equals(message1));
		
		entityManager1.getTransaction().commit();
		entityManager1.close();
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
