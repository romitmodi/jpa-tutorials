package org.learnings.jpa.object.relational.impedance.client.manytomany;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.manytomany.Actor;
import org.learnings.jpa.object.relational.impedance.model.manytomany.Movie;

public class ManyToManyClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();
		//ownerAction(session);
		inverseAction(session);
		session.getTransaction().commit();
		session.close();
	}

	private static void ownerAction(Session session) {
		Actor actor1 = new Actor("SRK", null);
		Actor actor2 = new Actor("Kriti", null);

		Movie movie1 = new Movie("XYZ", null);
		Movie movie2 = new Movie("ABCD", null);

		movie1.addActor(actor1);
		movie1.addActor(actor2);
		movie2.addActor(actor2);

		session.persist(movie1);
		session.persist(movie2);
	}

	private static void inverseAction(Session session) {
		Actor actor1 = session.get(Actor.class, 4);
		Movie movie2 = session.get(Movie.class, 4);
		actor1.addMovie(movie2);
		session.persist(movie2);
	}
}
