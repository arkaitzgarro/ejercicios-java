package com.arkaitzgarro.factories;

import com.arkaitzgarro.googleplex.Company;
import com.arkaitzgarro.googleplex.Employee;

public abstract class EmployeeFactory {
	
	public static Employee getNewEmployee(Company c, String name, float salary) {
		Employee e = new Employee(c, name, salary);
		
		return e;
	}
}
