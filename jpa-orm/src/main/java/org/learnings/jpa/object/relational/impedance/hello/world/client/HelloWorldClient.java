package org.learnings.jpa.object.relational.impedance.hello.world.client;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.model.Message;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;

public class HelloWorldClient {

	public static void main(String[] args) {
		// insertData();
		// readUpdateData();
		deleteData();
	}

	private static void insertData() {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Message message = new Message("Hello World! This is my first Message");
		session.save(message);

		session.getTransaction().commit();
		session.close();
	}

	private static void readUpdateData() {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Message messageOne = session.get(Message.class, 2l);
		System.out.println(messageOne.toString());

		// messageOne.setText("Text updation after Read using automatically dirty
		// Read");

		session.getTransaction().commit();
		session.close();

		messageOne.setText("updation after first session closure");

		session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();
		Message messageTwo = session.get(Message.class, 2l);

		// this will throw an error as session two is trying to update two different
		// entity object which are having same identifer.
		// session.update(messageOne);
		session.merge(messageOne);

		// messageTwo.setText("updation after two session closure");
		session.getTransaction().commit();
		session.close();
	}

	private static void deleteData() {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();
		Message messageTwo = session.get(Message.class, 2l);

		session.delete(messageTwo);
		session.getTransaction().commit();
		session.close();
	}
}
