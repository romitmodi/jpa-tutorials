package org.learnings.jpa.object.relational.impedance.model.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;

	@Column(name = "movie_name")
	private String movieName;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "movie_actor", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
	        @JoinColumn(name = "actor_id") })
	private Set<Actor> actors;

	public Movie() {
		super();
	}

	public Movie(String movieName, Set<Actor> actors) {
		super();
		this.movieName = movieName;
		this.actors = actors;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<Actor> getActors() {
		if (actors == null) {
			actors = new HashSet<>();
		}
		return actors;
	}

	public void addActor(Actor actor) {
		this.getActors().add(actor);
	}

	public void removeActor(Actor actor) {
		this.actors.remove(actor);
	}
}
