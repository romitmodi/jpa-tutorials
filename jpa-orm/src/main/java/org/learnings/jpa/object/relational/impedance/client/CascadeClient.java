package org.learnings.jpa.object.relational.impedance.client;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.cascade.Guide;
import org.learnings.jpa.object.relational.impedance.model.cascade.Student;

public class CascadeClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Guide guide = new Guide("John Kenedy", 1000, "JK12345");
		Student student = new Student("Robert", "200810JT123", guide);
		Student student2 = new Student("Robert", "200810JT123", guide);

		//session.save(guide);
		//session.save(student);
		
		//session.persist(student);
		//session.persist(student2);
		
		Student student3=session.get(Student.class, 3l);
		student3.setGuide(null);
		session.delete(student3);

		session.getTransaction().commit();
		session.close();
	}

}
