package com.arkaitzgarro.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.arkaitzgarro.factories.CompanyFactory;
import com.arkaitzgarro.factories.EmployeeFactory;
import com.arkaitzgarro.googleplex.Company;
import com.arkaitzgarro.googleplex.Employee;
import com.arkaitzgarro.interfaces.IEmployee;
import com.arkaitzgarro.interfaces.IExecutive;

public class GooglePlexTest {
	
	Company c;
	Employee e;

	@Before
	public void setUp() throws Exception {
		c = CompanyFactory.getNewCompany("Google", (short)100);
		e = EmployeeFactory.getNewEmployee(c, "Arkaitz Garro", 25000);
	}

	@Test
	public void testCompany() {
		assertEquals("Company name.", "Google", c.getName());
		assertEquals("Company size.", 100, c.getSize());
		
		IEmployee e = c.newEmployee("I–igo Garro", (float)60000.00);
		assertEquals("Employee name.", "I–igo Garro", e.getName());
		assertEquals("Employee company.", "Google", e.getCompany().getName());
		assertEquals((float)60000.00, e.getSalary(), 0);
		
		assertEquals(c.getNumEmployees(), 1);
		assertEquals("Empleado 1", c.getEmployee(e.getEmployeeId()), e);
		
		IEmployee e2 = c.newEmployee("Lourdes Garro", (float)90000.00);
		assertEquals("Employee name.", "Lourdes Garro", e2.getName());
		assertEquals("Employee company.", "Google", e2.getCompany().getName());
		assertEquals((float)90000.00, e2.getSalary(), 0);
		
		assertEquals(c.getNumEmployees(), 2);
			
		c.fireEmploye(e.getEmployeeId());
		assertEquals(c.getNumEmployees(), 1);
		
		assertEquals("Employee id.", 0, e.getEmployeeId());
		assertEquals("Employee company.", null, e.getCompany());
		
		((Employee) e2).promote();
		assertTrue(c.getEmployee(e2.getEmployeeId()) instanceof IExecutive);
	}
	
	@Test
	public void testEmployee() {
		assertEquals("Employee name.", "Arkaitz Garro", e.getName());
		assertEquals("Employee company.", "Google", e.getCompany().getName());
		assertEquals((float)25000.00, e.getSalary(), 0);
		
		e.raiseSalary(10);
		assertEquals((float)27500.00, e.getSalary(), 0);
	}

}
