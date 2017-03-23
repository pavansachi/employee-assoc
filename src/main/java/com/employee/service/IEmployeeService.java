package com.employee.service;

import java.util.Set;

import com.employee.model.Employee;
import com.employee.model.Project;

/**
 * service methods
 * @author pavansachi
 *
 */
public interface IEmployeeService {

	public Set<String> getTeamMates(Employee e1);
	
	public String getCommonManager(Employee e1, Employee e2);
	
	public String closestManager(Project p);
	
}
