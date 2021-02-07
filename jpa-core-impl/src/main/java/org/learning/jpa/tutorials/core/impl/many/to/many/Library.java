package org.learning.jpa.tutorials.core.impl.many.to.many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "MTM_LIBRARY")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	private String bookName;

	@ManyToMany(targetEntity = Student.class)
	List<Student> students;

	public Library() {
	}

	public Library(String bookName) {
		super();
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
