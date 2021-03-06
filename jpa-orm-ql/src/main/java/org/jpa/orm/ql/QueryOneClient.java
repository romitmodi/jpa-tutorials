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

		Guide g1 = new Guide("Rajat Modi", BigDecimal.valueOf(100000), "01SEP1989");
		Guide g2 = new Guide("Kunji Lal Agarwal", BigDecimal.valueOf(1000000), "05JUL1964");

		Student s1 = new Student("2021MAR06", "Romit", g1);
		Student s2 = new Student("e1", "newTest", null);

		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(g2);
		transaction.commit();
		transaction.begin();
		// JPQL usage
		jpqlTransaction(entityManager);
		// Criteria API
		criteriaApiTransaction(entityManager);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	private static void jpqlTransaction(EntityManager entityManager) {
		Query studentQuery = entityManager
		        .createQuery("SELECT s.name,s.enrollmentId from Student s where s.guide is null");
		List<Student> students = studentQuery.getResultList();
		System.out.println(students);

		Query guideQuery = entityManager.createQuery(
		        "select g.name, g.staffId from Guide g WHERE NOT Exists ( SELECT 1 from Student s where s.guide=g)");
		List<Guide> guides = guideQuery.getResultList();
		System.out.println(guides);

		Query query2 = entityManager.createQuery("select g from Guide g join g.students s WHERE s.name like 'R%'");
		guides = query2.getResultList();
		System.out.println(guides);
	}

	private static void criteriaApiTransaction(EntityManager entityManager) {

	}
}
