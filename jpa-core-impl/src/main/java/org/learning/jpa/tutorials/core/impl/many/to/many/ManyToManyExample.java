package org.learning.jpa.tutorials.core.impl.many.to.many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyExample {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Student s1 = new Student();
		s1.setName("Romit Modi");
		s1.setFees(100);
		
		Student s2 = new Student();
		s2.setName("Rajat Modi");
		s2.setFees(100);
		
		entityManager.persist(s1);
		entityManager.persist(s2);
		
		List<Student> sl=new ArrayList<Student>();
		sl.add(s2);
		sl.add(s1);
		
		Library lib1 = new Library("Data Structure");
		Library lib2 = new Library("Data Structure using Java");
		lib1.setStudents(sl);


		entityManager.persist(lib1);
		entityManager.persist(lib2);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
