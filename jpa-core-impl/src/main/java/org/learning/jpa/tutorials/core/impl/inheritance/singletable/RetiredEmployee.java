package org.learning.jpa.tutorials.core.impl.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class RetiredEmployee extends Employee {
	private int pension;

	public RetiredEmployee() {
		super();
	}

	public RetiredEmployee(String name, int pension) {
		super(name);
		this.pension = pension;
	}

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

}
