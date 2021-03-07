package org.jpa.orm.ipq.single.table.entity;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

	public Cat() {
		super();
	}

	public Cat(String name) {
		super(name);
	}

	@Override
	public String makeNoise() {
		return "Meow Meow..";
	}
}
