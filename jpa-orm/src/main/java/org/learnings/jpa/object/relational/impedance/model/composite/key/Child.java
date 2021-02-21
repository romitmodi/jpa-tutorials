package org.learnings.jpa.object.relational.impedance.model.composite.key;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "child")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumns({ @JoinColumn(name = "firstname_p", referencedColumnName = "firstname"),
	        @JoinColumn(name = "lastname_p", referencedColumnName = "lastname") })
	private Parent parent;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child(String name, Parent parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}
