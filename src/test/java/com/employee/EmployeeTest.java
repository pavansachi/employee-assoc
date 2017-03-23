package com.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.employee.model.Employee;
import com.employee.model.Project;
import com.employee.service.IEmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;

public class EmployeeTest {

	private IEmployeeService svc = new EmployeeServiceImpl();

	private Employee simon, lisa, leonard,
	sam, lucy, james, jack, john;

	private Project pa, pb, pc;

	@Before
	public void setUp() {

		pa = new Project();
		pa.setName("proj A");
		pb = new Project();
		pb.setName("proj B");
		pc = new Project();
		pc.setName("proj C");

		simon = new Employee();
		simon.setName("simon");

		lisa = new Employee();
		lisa.setName("lisa");
		lisa.setManager(simon);

		leonard = new Employee();
		leonard.setName("leonard");
		leonard.setManager(simon);

		sam = new Employee();
		sam.setName("sam");
		sam.setManager(leonard);
		sam.setProjects(Arrays.asList(pb));

		lucy = new Employee();
		lucy.setName("lucy");
		lucy.setManager(leonard);
		lucy.setProjects(Arrays.asList(pb, pc));

		james = new Employee();
		james.setName("james");
		james.setManager(leonard);
		james.setProjects(Arrays.asList(pa, pc));

		jack = new Employee();
		jack.setName("jack");
		jack.setManager(lisa);
		jack.setProjects(Arrays.asList(pa));

		john = new Employee();
		john.setName("john");
		john.setManager(lisa);
		john.setProjects(Arrays.asList(pa, pb));

	}

	@Test
	public void testGetTeamMates() {

		Set<String> teammates = svc.getTeamMates(james);

		List<String> mates = new ArrayList<String>(teammates);

		Assert.assertThat(mates, CoreMatchers.is(Arrays.asList("john", "lucy", "jack")));

	}

	@Test
	public void testGetClosestMaanger() {

		String manager = svc.closestManager(pa);

		Assert.assertEquals("lisa", manager);

		manager = svc.closestManager(pb);

		Assert.assertEquals("leonard", manager);
		
		manager = svc.closestManager(pc);

		Assert.assertEquals("leonard", manager);

	}

	@Test
	public void testGetCommonManager() {

		String manager = svc.getCommonManager(john, jack);

		Assert.assertEquals("lisa", manager);

		manager = svc.getCommonManager(john, sam);

		Assert.assertEquals("simon", manager);

		manager = svc.getCommonManager(john, simon);

		Assert.assertEquals("simon", manager);

	}

}
