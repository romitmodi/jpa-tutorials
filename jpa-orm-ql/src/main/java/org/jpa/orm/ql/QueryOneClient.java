package org.jpa.orm.ql;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jpa.orm.ql.entity.Guide;
import org.jpa.orm.ql.entity.Student;

public class QueryOneClient {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-ql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Guide g1  = new Guide("Rajat Modi", BigDecimal.valueOf(100000), "01SEP1989");
		Guide g2 = new Guide("Kunji Lal Agarwal", BigDecimal.valueOf(1000000),"05JUL1964");
		
		Student s1 = new Student("2021MAR06", "Romit", g1);
		Student s2= new Student("e1", "newTest", null);
		
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(g2);
		transaction.commit();
		transaction.begin();
		Query studentQuery = entityManager
		        .createQuery("SELECT s.name,s.enrollmentId from Student s where s.guide is null");
		List<Student> students = studentQuery.getResultList();
		System.out.println(students);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
