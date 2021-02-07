package org.learning.jpa.tutorials.core.impl.OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//required annotation
@Entity(name = "OTM_Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long fees;

	@OneToMany(targetEntity = Library.class)
	private List booksIssued;

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

	public List getBooksIssued() {
		return booksIssued;
	}

	public void setBooksIssued(List booksIssued) {
		this.booksIssued = booksIssued;
	}

}
