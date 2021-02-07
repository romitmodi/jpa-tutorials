package org.learning.jpa.tutorials.core.impl.many.to.many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//required annotation
@Entity(name = "MTM_Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long fees;

	@ManyToMany(targetEntity = Library.class)
	private List<Library> booksIssued;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFees() {
		return fees;
	}

	public void setFees(long fees) {
		this.fees = fees;
	}

	public List<Library> getBooksIssued() {
		return booksIssued;
	}

	public void setBooksIssued(List<Library> booksIssued) {
		this.booksIssued = booksIssued;
	}

}
