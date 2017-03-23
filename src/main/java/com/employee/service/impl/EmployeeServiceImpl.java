package com.employee.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.employee.model.Employee;
import com.employee.model.Project;
import com.employee.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public String getCommonManager(Employee e1, Employee e2) {
		
		return getManager(e1, e2);
	}

	@Override
	public Set<String> getTeamMates(Employee e1) {
		
		Set<String> teammates = new HashSet<String>();

		for (Project p: e1.getProjects()) {

			for (Employee e: p.getEmployees()) {

				teammates.add(e.getName());
			}
		}

		teammates.remove("james");

		return teammates;
	}
	
	private static String getManager(Employee e1, Employee e2) {

		if (e1.getName().equalsIgnoreCase(e2.getName())) {

			return e1.getName();
		}

		// e1 has reached top
		if (e1.getManager() == null && e2.getManager() != null) {

			return getManager(e1, e2.getManager());
		}

		// e2 has reached top
		if (e2.getManager() == null && e1.getManager() != null) {

			return getManager(e1.getManager(), e2);
		}

		return getManager(e1.getManager(), e2.getManager());
	}

	@Override
	public String closestManager(Project p) {

		Map<String, Integer> managers = new HashMap<String, Integer>();
		
		p.getEmployees().forEach((e) -> {
			
			String name = e.getManager().getName();
			
			if (managers.get(name) == null) {
				managers.put(name, 1);
			}
			else {
				int newcount = managers.get(name).intValue() + 1;
				managers.put(name, newcount);
			}
		});
		
		int max = -1; 
		String manager = null;
		
		for (String e: managers.keySet()) {
			
			int count = managers.get(e);
			
			if (count > max) {
				max = count;
				manager = e;
			}
		}
		
		return manager;
	}

}
