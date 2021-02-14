package org.learnings.jpa.object.relational.impedance.client;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.cascade.Guide;
import org.learnings.jpa.object.relational.impedance.model.cascade.Student;

public class InverseClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Guide guide = session.get(Guide.class, 10l);
		Student student = session.get(Student.class, 11l);
		guide.getStudents().add(student);
		//student.setGuide(guide);
		session.getTransaction().commit();
		session.close();
	}

}
