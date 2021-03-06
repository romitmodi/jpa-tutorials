package org.jpa.orm.ql;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

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
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// Scenario:-1 complete entity object
		CriteriaQuery<Guide> criteriaQuery = builder.createQuery(Guide.class);
		Root<Guide> root = criteriaQuery.from(Guide.class);
		criteriaQuery.select(root);
		TypedQuery<Guide> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Guide> guides = typedQuery.getResultList();
		guides.forEach(g -> System.out.println(g.toString()));

		// Scenario:-2 single attributes
		CriteriaQuery<String> criteriaQuery2 = builder.createQuery(String.class);
		root = criteriaQuery2.from(Guide.class);
		Path<String> path = root.get("name");
		criteriaQuery2.select(path);
		TypedQuery<String> typedQuery2 = entityManager.createQuery(criteriaQuery2);
		List<String> guidesName = typedQuery2.getResultList();
		guidesName.forEach(g -> System.out.println(g.toString()));

		// Scenario:-3.1 multiple attributes using select
		CriteriaQuery<Object[]> query3 = builder.createQuery(Object[].class);
		root = query3.from(Guide.class);
		Path<String> nameP = root.get("name");
		Path<BigDecimal> salaryP = root.get("salary");
		query3.select(builder.array(nameP, salaryP));
		TypedQuery<Object[]> typedQuery3 = entityManager.createQuery(query3);
		List<Object[]> objects = typedQuery3.getResultList();
		objects.forEach(o -> System.out.println(o[0] + " " + o[1]));

		// Scenario:-3.2 multiple attributes using multiselect
		CriteriaQuery<Object[]> criteriaQuery3 = builder.createQuery(Object[].class);
		root = criteriaQuery3.from(Guide.class);
		criteriaQuery3.multiselect(root.get("name"), root.get("salary"));
		TypedQuery<Object[]> typedQuery4 = entityManager.createQuery(criteriaQuery3);
		List<Object[]> objects1 = typedQuery4.getResultList();
		objects1.forEach(o -> System.out.println(o[0] + " " + o[1]));
	}
}
