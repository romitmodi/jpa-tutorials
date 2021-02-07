package org.learning.jpa.tutorials.core.impl.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class ActiveEmployee extends Employee {

	private int expYears;
	private int salary;

	public ActiveEmployee() {
		super();
	}

	public ActiveEmployee(String name, int expYears, int salary) {
		super(name);
		this.expYears = expYears;
		this.salary = salary;
	}

	public int getExpYears() {
		return expYears;
	}

	public void setExpYears(int expYears) {
		this.expYears = expYears;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
