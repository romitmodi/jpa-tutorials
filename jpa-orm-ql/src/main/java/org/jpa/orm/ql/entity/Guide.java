package org.jpa.orm.ql.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private BigDecimal salary;
	private String staffId;

	@OneToMany(mappedBy = "guide", orphanRemoval = true)
	private Collection<Student> students;

	public Guide() {
		super();
	}

	public Guide(String name, BigDecimal salary, String staffId) {
		super();
		this.name = name;
		this.salary = salary;
		this.staffId = staffId;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Collection<Student> getStudents() {
		if (students == null) {
			students = new HashSet<Student>();
		}
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		this.getStudents().add(student);
		student.setGuide(this);
	}

	public void removeStudent(Student student) {
		this.getStudents().remove(student);
		student.setGuide(null);
	}

}
