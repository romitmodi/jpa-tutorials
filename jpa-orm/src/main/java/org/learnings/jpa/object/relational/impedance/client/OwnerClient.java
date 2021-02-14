package org.learnings.jpa.object.relational.impedance.client;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.cascade.Guide;
import org.learnings.jpa.object.relational.impedance.model.cascade.Student;

public class OwnerClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Guide guide1 = new Guide("John Kenedy Jr", 1000, "JK12345");
		Guide guide2 = new Guide("John Kenedy Sr", 1000, "JK12345");
		Student student1 = new Student("Robert Jr", "200810JT123", guide1);
		Student student2 = new Student("Robert Sr", "200810JT123", guide1);
		
		guide1.getStudents().add(student1);
		guide1.getStudents().add(student2);
		
		session.persist(guide1);
		session.persist(guide2);
		
		
		//student1.setGuide(guide2);
		
		session.getTransaction().commit();
		session.close();
	}

}
