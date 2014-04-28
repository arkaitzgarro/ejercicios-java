package com.arkaitzgarro.googleplex;

import com.arkaitzgarro.interfaces.ICompany;
import com.arkaitzgarro.interfaces.IEmployee;
import com.arkaitzgarro.poo.EJ_06.Ejecutivo;

public class Employee implements IEmployee {
	
	private short id;
	private String name;
	private float salary;
	private ICompany company;
	
	public Employee(ICompany c, String name, float salary) {
		this.company = c;
		this.name = name;
		this.salary = salary;
	}
	
	protected Employee(ICompany c, String name, float salary, short id) {
		this(c, name, salary);
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public float getSalary() {
		return this.salary;
	}
	
	public final void raiseSalary(int raise) {
		float newSalary = this.salary + (this.salary*raise)/100;
		this.setSalary(newSalary);
	}

	@Override
	public short getEmployeeId() {
		return this.id;
	}

	@Override
	public void fire() {
		this.company = null;
		this.id = 0;
	}

	@Override
	public ICompany getCompany() {
		return this.company;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append(this.id);
		s.append(" - ");
		s.append(this.name);
		s.append(" - ");
		s.append(this.salary);
		
		return s.toString();
	}
	
	public void promote() {
		Executive executive = new Executive(this.company, this.name, this.salary, this.id);
		executive.getCompany().setEmployee(executive, executive.getEmployeeId());
	}
}
