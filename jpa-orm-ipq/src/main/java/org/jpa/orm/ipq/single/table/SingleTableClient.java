package org.jpa.orm.ipq.single.table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jpa.orm.ipq.single.table.entity.Cat;
import org.jpa.orm.ipq.single.table.entity.Dog;

public class SingleTableClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-ipq");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Dog dog1 = new Dog("Lab");
		Cat cat = new Cat("Lucy");

		em.persist(cat);
		em.persist(dog1);
		et.commit();
		System.out.println(cat.toString());
		System.out.println(dog1.toString());
		em.close();
		emf.close();
	}

}
