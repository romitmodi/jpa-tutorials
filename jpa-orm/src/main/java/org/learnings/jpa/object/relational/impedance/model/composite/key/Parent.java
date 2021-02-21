package org.learnings.jpa.object.relational.impedance.model.composite.key;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class Parent {

	@EmbeddedId
	private ParentPrimaryKey key;

	@OneToMany(mappedBy = "parent", cascade = { CascadeType.PERSIST })
	private Collection<Child> childs;

	public Parent() {
		super();
	}

	public Parent(ParentPrimaryKey key) {
		super();
		this.key = key;
	}

	public ParentPrimaryKey getKey() {
		return key;
	}

	public void setKey(ParentPrimaryKey key) {
		this.key = key;
	}

	public Collection<Child> getChilds() {
		if (childs == null) {
			childs = new HashSet<>();
		}
		return childs;
	}

	public void addChild(Child child) {
		this.getChilds().add(child);
		child.setParent(this);
	}

	public void removeChild(Child child) {
		this.getChilds().remove(child);
		child.setParent(null);
	}

}
