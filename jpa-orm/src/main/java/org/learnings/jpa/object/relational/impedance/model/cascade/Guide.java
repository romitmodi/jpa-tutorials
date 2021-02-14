package org.learnings.jpa.object.relational.impedance.model.cascade;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "guide")
public class Guide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private long salary;

	@Column(name = "staff_id")
	private String staffId;

	/**
	 * Inorder to make this relation as bi-directional and link via one to many
	 * mapping. Below is needed.
	 */
	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "guide", orphanRemoval = true)
	private Set<Student> students;

	public Guide() {
		super();
	}

	public Guide(String name, long salary, String staffId) {
		super();
		this.name = name;
		this.salary = salary;
		this.staffId = staffId;
	}

	public Guide(String name, long salary, String staffId, Set<Student> students) {
		super();
		this.name = name;
		this.salary = salary;
		this.staffId = staffId;
		this.students = students;
	}

	public Set<Student> getStudents() {
		if (students == null) {
			students = new HashSet<>();
		}
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

}
