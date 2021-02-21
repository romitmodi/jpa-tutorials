package org.learnings.jpa.object.relational.impedance.model.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private int actorId;

	@Column(name = "actor_name")
	private String actorName;

	@ManyToMany(mappedBy = "actors", cascade = { CascadeType.PERSIST })
	private Set<Movie> movies;

	public Actor() {
		super();
	}

	public Actor(String actorName, Set<Movie> movies) {
		super();
		this.actorName = actorName;
		this.movies = movies;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Set<Movie> getMovies() {
		if (movies == null) {
			movies = new HashSet<>();
		}
		return movies;
	}

	public void addMovie(Movie movie) {
		this.getMovies().add(movie);
		movie.addActor(this);
	}

	public void removeMovie(Movie movie) {
		this.movies.remove(movie);
		movie.removeActor(this);
	}

}
