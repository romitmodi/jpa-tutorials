package org.learnings.jpa.object.relational.impedance.client.enums;

import org.hibernate.Session;
import org.learnings.jpa.object.relational.impedance.hello.world.utils.HibernateUtils;
import org.learnings.jpa.object.relational.impedance.model.enums.Employee;
import org.learnings.jpa.object.relational.impedance.model.enums.EmployeeType;

public class EnumClient {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().openSession();
		session.getTransaction().begin();

		Employee employeeOne = new Employee("Romit", EmployeeType.FULL_TIME);
		Employee employeeTwo = new Employee("Rajat", EmployeeType.PART_TIME);
		session.save(employeeTwo);
		session.save(employeeOne);
		session.getTransaction().commit();
		session.close();
	}
}