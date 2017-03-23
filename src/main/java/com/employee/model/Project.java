package com.employee.model;

import java.util.HashSet;
import java.util.Set;

/**
 * model to represent project
 * @author pavansachi
 *
 */
public class Project {

	private String name;

	private Set<Employee> employees = new HashSet<Employee>();
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
