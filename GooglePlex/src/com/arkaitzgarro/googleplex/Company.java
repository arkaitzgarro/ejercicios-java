package com.arkaitzgarro.googleplex;

import java.util.ArrayList;

import com.arkaitzgarro.interfaces.ICompany;
import com.arkaitzgarro.interfaces.IEmployee;
import com.arkaitzgarro.interfaces.IExecutive;

public class Company implements ICompany {

	private String name;
	private short size;
	private ArrayList<IEmployee> employees;
	private static short counter = 0;
	
	public Company(String name, short size) {
		this.name = name;
		this.size = size;
		
		this.employees = new ArrayList<IEmployee>(this.size);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public short getSize() {
		return this.size;
	}

	@Override
	public void fireEmploye(short id) {
		IEmployee e = this.getEmployee(id);
		
		if(this.employees.contains(e)) {
			this.employees.remove(e);
			e.fire();
		}
	}

	@Override
	public IEmployee newEmployee(String name, float salary) {
		if(this.employees.size() == this.size) {
			// TODO
		}
		
		IEmployee employee = new Employee(this, name, salary, ++counter);		
		this.employees.add(employee);

		return employee;
	}

	@Override
	public IEmployee getEmployee(short id) {
		for(IEmployee e : this.employees) {
			if(e.getEmployeeId() == id) {
				return e;
			}
		}
		
		return null;
	}
	
	public short getNumEmployees() {
		return (short)this.employees.size();
	}
	
	public void setEmployee(IExecutive ex, short id) {
		IEmployee e = this.getEmployee(id);
		
		if(this.employees.contains(e)) {
			this.employees.set(this.employees.indexOf(e), ex);
		}
	}

}
