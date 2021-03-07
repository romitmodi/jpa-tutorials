package org.jpa.orm.ipq.single.table.entity;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

	@Override
	public String makeNoise() {
		return "Woof Woof...";
	}

}
