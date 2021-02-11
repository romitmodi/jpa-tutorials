package org.learnings.jpa.object.relational.impedance.model.component;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	//@Column(name = "street")
	private String street;

	//@Column(name = "city")
	private String city;

	//@Column(name = "zipcode")
	private String zipcode;

	public Address() {
		super();
	}

	public Address(String street, String city, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
