package org.learnings.jpa.object.relational.impedance.model.composite.key;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ParentPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;

	public ParentPrimaryKey() {
		super();
	}

	public ParentPrimaryKey(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int hashCode() {
		int result = firstname.hashCode();
		result = 31 * result + lastname.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ParentPrimaryKey parentPrimaryKey = (ParentPrimaryKey) o;
		if (!firstname.equals(parentPrimaryKey.firstname))
			return false;
		if (!lastname.equals(parentPrimaryKey.lastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParentPrimaryKey [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
