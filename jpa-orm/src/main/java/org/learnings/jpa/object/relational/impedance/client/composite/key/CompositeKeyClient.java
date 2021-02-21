package org.learnings.jpa.object.relational.impedance.client.composite.key;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.composite.key.Child;
import org.learnings.jpa.object.relational.impedance.model.composite.key.Parent;
import org.learnings.jpa.object.relational.impedance.model.composite.key.ParentPrimaryKey;

public class CompositeKeyClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		ParentPrimaryKey key = new ParentPrimaryKey("Kunji", "Modi");
		Parent parent = new Parent(key);
		Child child = new Child("Romit", null);
		parent.addChild(child);
		session.persist(parent);

		session.getTransaction().commit();
		session.close();
	}

}
