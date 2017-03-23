package com.employee.model;

import java.util.List;

/**
 * model to represent employee
 * @author pavansachi
 *
 */
public class Employee {

	private String name;
	private Employee manager;
	private List<Project> projects;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", manager=" + manager + ", projects=" + projects + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		
		for (Project p: projects) {
			p.getEmployees().add(this);
		}
		
		this.projects = projects;
	}
	
	
}
