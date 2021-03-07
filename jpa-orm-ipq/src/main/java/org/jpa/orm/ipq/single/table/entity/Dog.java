package org.jpa.orm.ipq.single.table.entity;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

	public Dog() {
		super();
	}

	public Dog(String name) {
		super(name);
	}

	@Override
	public String makeNoise() {
		return "Woof Woof...";
	}

}
