package org.jpa.orm.ipq.single.table.entity;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

	@Override
	public String makeNoise() {
		return "Meow Meow..";
	}

}
