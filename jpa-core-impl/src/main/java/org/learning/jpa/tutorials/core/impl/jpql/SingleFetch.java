package org.learning.jpa.tutorials.core.impl.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SingleFetch {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		orderByMethod(entityManager);
		whereMethod(entityManager);

	}
	private static void whereMethod(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		AbstractQuery<StudentEntity> criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);

		Root<StudentEntity> root = criteriaQuery.from(StudentEntity.class);

		criteriaQuery.where(criteriaBuilder.greaterThan(root.get("s_id"), 1));
		
		CriteriaQuery<StudentEntity> criteriaQuery2 = ((CriteriaQuery<StudentEntity>) criteriaQuery).select(root);
		Query query = entityManager.createQuery(criteriaQuery2);
		List<StudentEntity> entities = query.getResultList();

		entities.forEach(s -> System.out.println(s.getS_name() + s.getS_age()));
		entityManager.getTransaction().commit();
	}

	private static void orderByMethod(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<StudentEntity> criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);

		Root<StudentEntity> root = criteriaQuery.from(StudentEntity.class);

		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("s_id")));
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("s_age")));
		CriteriaQuery<StudentEntity> criteriaQuery2 = criteriaQuery.select(root);

		Query query = entityManager.createQuery(criteriaQuery2);
		List<StudentEntity> entities = query.getResultList();

		entities.forEach(s -> System.out.println(s.getS_name() + s.getS_age()));
		entityManager.getTransaction().commit();
	}

}
